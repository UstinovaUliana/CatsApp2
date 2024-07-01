package com.ustinovauliana.cats.api.utils

import okhttp3.Interceptor
import okhttp3.Response

internal class CatsApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .addHeader("X-Api_Key",apiKey)
                .build()
        )
    }
}
