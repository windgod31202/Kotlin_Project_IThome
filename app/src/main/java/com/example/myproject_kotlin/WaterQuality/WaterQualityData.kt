package com.example.myproject_kotlin.WaterQuality

data class WaterQualityData(
    val update_date: String,
    val update_time: String,
    val code_name: String,
    val longitude: String,
    val latitude: String,
    val qua_id: String,
    val qua_cntu: String,
    val qua_cl: String,
    val qua_ph: String
)
