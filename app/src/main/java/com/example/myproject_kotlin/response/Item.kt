package com.example.myproject_kotlin.response

import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("update_date")
    lateinit var update_date: String
    @SerializedName("update_time")
    lateinit var update_time: String
    @SerializedName("qua_id")
    lateinit var qua_id: String
    @SerializedName("code_name")
    lateinit var code_name: String
    @SerializedName("longitude")
    lateinit var longitude: String
    @SerializedName("latitude")
    lateinit var latitude: String
    @SerializedName("qua_cntu")
    lateinit var qua_cntu: String
    @SerializedName("qua_cl")
    lateinit var qua_cl: String
    @SerializedName("qua_ph")
    lateinit var qua_ph: String
}