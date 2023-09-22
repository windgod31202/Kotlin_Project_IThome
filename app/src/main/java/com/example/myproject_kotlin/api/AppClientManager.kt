package com.example.myproject_kotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {
    private val retrofit: Retrofit
    private lateinit var okHttpClient: OkHttpClient

    init {
        okHttpClient = OkHttpClient.Builder()
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.water.gov.taipei")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory( RxJava3CallAdapterFactory.create())
            .build()
    }
    // 伴生物件
    companion object {
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}