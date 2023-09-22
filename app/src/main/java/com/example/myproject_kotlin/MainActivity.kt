package com.example.myproject_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myproject_kotlin.WaterQuality.WaterQuality

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.calculateButton)
        // 台北水質檢測跳轉按鈕
        val button_taipeiWaterQuality = findViewById<Button>(R.id.getAPIButton)
        button.setOnClickListener {
            val intent = Intent(this, CalculatorMachine::class.java)
            startActivity(intent)
        }
        button_taipeiWaterQuality.setOnClickListener {
            val intent = Intent(this, WaterQuality::class.java)
            startActivity(intent)
        }
    }
}