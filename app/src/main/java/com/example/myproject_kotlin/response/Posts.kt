package com.example.myproject_kotlin.response

import com.google.gson.annotations.SerializedName

class Posts {
    @SerializedName("httpCode")
    lateinit var httpCode: String
    @SerializedName("httpMessage")
    lateinit var httpMessage: String
    @SerializedName("count")
    var count: Int = 0
    @SerializedName("item")
    var item: List<Item> = listOf()


}