package com.example.myproject_kotlin.api


import com.example.myproject_kotlin.response.Posts
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.POST

interface ApiService {

    @POST("/prod/WaterQualityData")
    fun getPosts(): Observable<Response<Posts>>
}