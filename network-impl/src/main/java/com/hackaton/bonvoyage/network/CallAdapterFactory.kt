package com.hackaton.bonvoyage.network

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.concurrent.Executor

class CallAdapterFactory(private val executor: Executor) : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java) {
            return null
        }
        val responseType = getCallResponseType(returnType)
        return object : CallAdapter<Any?, Call<*>> {
            override fun responseType(): Type {
                return responseType
            }

            override fun adapt(call: Call<Any?>): Call<Any?> {
                return ExecutorCallbackCall(call, executor, retrofit)
            }
        }
    }

    private fun getCallResponseType(returnType: Type): Type {
        require(returnType is ParameterizedType) { "Call return type must be parameterized" }
        return getParameterUpperBound(0, returnType)
    }

    class ExecutorCallbackCall<T>(
        private val delegateCall: Call<T>,
        private val executor: Executor,
        private val retrofit: Retrofit
    ) : Call<T> by delegateCall {

        override fun clone(): Call<T> {
            return ExecutorCallbackCall(delegateCall.clone(), executor, retrofit)
        }

        override fun enqueue(callback: Callback<T>) {
            delegateCall.enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {

                    Log.i("http errors", "$response --- resp")
                    executor.execute {
                        if (response.isSuccessful) {
                            callback.onResponse(this@ExecutorCallbackCall, response)
                        } else {
                            callback.onFailure(this@ExecutorCallbackCall, Throwable("${response.code()}"))
                        }
                    }
                }

                override fun onFailure(call: Call<T>, throwable: Throwable) {
                    executor.execute {
                        callback.onFailure(this@ExecutorCallbackCall, throwable)
                    }
                }
            })
        }
    }

    class MainThreadExecutor : Executor {

        private val handler = Handler(Looper.getMainLooper())

        override fun execute(r: Runnable) {
            handler.post(r)
        }
    }


    companion object {

        fun create(): CallAdapter.Factory {
            return CallAdapterFactory(MainThreadExecutor())
        }
    }
}