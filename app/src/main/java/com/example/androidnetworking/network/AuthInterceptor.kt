package com.example.androidnetworking.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthInterceptor : Interceptor {



    override fun intercept(chain: Interceptor.Chain): Response {

        var request: Request = chain.request()
        //val url: HttpUrl = request.url().newBuilder().addQueryParameter("key",  "94d124c031ba4486b9c81847222402").build()
        //request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}