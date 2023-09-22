package com.example.myproject_kotlin.WaterQuality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_kotlin.MainActivity
import com.example.myproject_kotlin.R
import com.example.myproject_kotlin.api.ApiService
import com.example.myproject_kotlin.api.AppClientManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WaterQuality : AppCompatActivity() {
    private val TAG = "WaterQuality"
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WaterQualityAdapter
    private val service  = AppClientManager.client.create(ApiService::class.java)
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_quality)

        service.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {response ->
                    val posts = response.body()
                    adapter = WaterQualityAdapter(listOf())

                    if (posts != null) {
                        // 在这里处理从API获取的数据
                        val items = response.body()?.item // 获取item列表
                        if (items != null) {
                            val waterQualityList = mutableListOf<WaterQualityData>() // 创建一个用于存储数据的列表
                            for (item in items) {
                                val updateDate = item.update_date
                                val updateTime = item.update_time
                                val codeName = item.code_name
                                val longitude = item.longitude
                                val latitude = item.latitude
                                val quaId = item.qua_id
                                val quaCntu = item.qua_cntu
                                val quaCl = item.qua_cl
                                val quaPh = item.qua_ph

                                // 创建WaterQualityData对象并添加到列表中
                                waterQualityList.add(WaterQualityData(updateDate, updateTime, codeName, longitude, latitude, quaId, quaCntu, quaCl, quaPh))
                            }

                            // 创建适配器并将列表传递给适配器
                            adapter = WaterQualityAdapter(waterQualityList)

                            // 设置RecyclerView的适配器
                            recyclerView.adapter = adapter
                            adapter.notifyDataSetChanged()
                        }
                        val status = posts.httpMessage
                        Toast.makeText(this, "Status: $status", Toast.LENGTH_SHORT).show()
                        // 进行进一步的处理
                    } else {
                        // 处理响应为空的情况
                    }
                },
                { error ->
                    println(error)
                }
            )

        imageView = findViewById(R.id.backToHome)
        imageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.waterQualityRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}