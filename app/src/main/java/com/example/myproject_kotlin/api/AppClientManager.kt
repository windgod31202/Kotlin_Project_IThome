package com.example.myproject_kotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {
    private val retrofit: Retrofit
    private val okHttpClient: OkHttpClient

    // 初始化的時候創建了 OkHttpClient 和 Retrofit 實例。
    init {
        okHttpClient = OkHttpClient.Builder()
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.water.gov.taipei")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    // 伴生物件
    // 通過伴生物件創建了 AppClientManager 的單例實例 manager，
    // 並提供了一個 client 屬性，用於訪問 Retrofit 實例。
    // 這意味著您可以通過 AppClientManager.client 來獲取全局共享的 Retrofit 實例，
    // 而不需要每次創建一個新的實例。
    companion object {
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}