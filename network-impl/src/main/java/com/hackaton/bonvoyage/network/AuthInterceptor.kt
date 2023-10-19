package com.hackaton.bonvoyage.network

import com.hackaton.persistence.PreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val preferenceManager: PreferenceManager
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequestBuilder = chain.request().newBuilder()
        val token = preferenceManager.accessToken
        token?.let { newRequestBuilder.addHeader(TOKEN_HEADER, it) }
        return chain.proceed(newRequestBuilder.build())
    }

    companion object {
        private const val TOKEN_HEADER = "authorization"
    }
}