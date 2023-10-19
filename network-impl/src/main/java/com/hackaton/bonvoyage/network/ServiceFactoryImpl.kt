package com.hackaton.bonvoyage.network

import com.google.gson.Gson
import com.hackaton.network.services.ServiceFactoryApi
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactoryImpl(
    private val okHttpClientBuilder: OkHttpClient.Builder,
    private val callAdapterFactory: CallAdapter.Factory
): ServiceFactoryApi {

    override fun <S> createService(apiClass: Class<S>): S {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClientBuilder.build())
            .build()
            .create(apiClass)
    }

    companion object {

        private const val BASE_URL = "http://195.2.79.164:2309"
    }
}