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

    // getter and setter
    @JvmName("getUpdate_date_")
    fun getUpdate_date(): String {
        return update_date
    }
    @JvmName("setUpdate_date_")
    fun setUpdate_date(update_date: String) {
        this.update_date = update_date
    }
    @JvmName("getUpdate_time_")
    fun getUpdate_time(): String {
        return update_time
    }
    @JvmName("setUpdate_time_")
    fun setUpdate_time(update_time: String) {
        this.update_time = update_time
    }
    @JvmName("getQua_id_")
    fun getQua_id(): String {
        return qua_id
    }
    @JvmName("setQua_id_")
    fun setQua_id(qua_id: String) {
        this.qua_id = qua_id
    }
    @JvmName("getCode_name_")
    fun getCode_name(): String {
        return code_name
    }
    @JvmName("setCode_name_")
    fun setCode_name(code_name: String) {
        this.code_name = code_name
    }
    @JvmName("getLongitude_")
    fun getLongitude(): String {
        return longitude
    }
    @JvmName("setLongitude_")
    fun setLongitude(longitude: String) {
        this.longitude = longitude
    }
    @JvmName("getLatitude_")
    fun getLatitude(): String {
        return latitude
    }
    @JvmName("setLatitude_")
    fun setLatitude(latitude: String) {
        this.latitude = latitude
    }
    @JvmName("getQua_cntu_")
    fun getQua_cntu(): String {
        return qua_cntu
    }
    @JvmName("setQua_cntu_")
    fun setQua_cntu(qua_cntu: String) {
        this.qua_cntu = qua_cntu
    }
    @JvmName("getQua_cl_")
    fun getQua_cl(): String {
        return qua_cl
    }
    @JvmName("setQua_cl_")
    fun setQua_cl(qua_cl: String) {
        this.qua_cl = qua_cl
    }
    @JvmName("getQua_ph_")
    fun getQua_ph(): String {
        return qua_ph
    }
    @JvmName("setQua_ph_")
    fun setQua_ph(qua_ph: String) {
        this.qua_ph = qua_ph
    }
}