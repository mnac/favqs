package com.android.favqs.data.service.remote

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

interface SessionInterceptor {
    fun setSessionToken(token: String?)
}

class HeadersInterceptor @Inject constructor() : Interceptor, SessionInterceptor {
    companion object {
        private const val APP_TOKEN = "86d80e48aa477186b3d2cf5840c4344b"

        private const val CONTENT_TYPE_HEADER_KEY = "Content-Type"
        private const val CONTENT_TYPE_HEADER_VALUE = "application/json"

        private const val AUTHORIZATION_HEADER_KEY = "Authorization"
        private const val AUTHORIZATION_HEADER_VALUE = "Token token=\"${APP_TOKEN}\""

        private const val SESSION_HEADER_KEY = "User-Token"
    }

    private var sessionToken: String? = null

    override fun setSessionToken(token: String?) {
        this.sessionToken = token
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain
            .request()
            .newBuilder()
            .header(CONTENT_TYPE_HEADER_KEY, CONTENT_TYPE_HEADER_VALUE)
            .header(AUTHORIZATION_HEADER_KEY, AUTHORIZATION_HEADER_VALUE)

        sessionToken?.let {
            requestBuilder.header(SESSION_HEADER_KEY, it)
        }

        return chain.proceed(requestBuilder.build())
    }
}