package com.example.myproject_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CalculatorMachine : AppCompatActivity() {
    private lateinit var calculator: Calculator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        calculator = Calculator()

        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonDecimal = findViewById<Button>(R.id.buttonDecimal)
        val buttonEquals = findViewById<Button>(R.id.buttonEquals)

        val digitButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)

        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonClear.setOnClickListener {
            calculator.clear() // 調用 calculator 的清除方法
            resultTextView.text = calculator.getCurrentInput()
        }

        buttonBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 設置數字按鈕的點擊事件
        digitButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                calculator.appendDigit(index)
                resultTextView.text = calculator.getCurrentInput()
            }
        }

        // 設置運算符號按鈕的點擊事件
        buttonAdd.setOnClickListener {
            calculator.setOperator("+")
        }

        buttonSubtract.setOnClickListener {
            calculator.setOperator("-")
        }

        buttonMultiply.setOnClickListener {
            calculator.setOperator("*")
        }

        buttonDivide.setOnClickListener {
            calculator.setOperator("/")
        }

        // 設置等於按鈕的點擊事件
        buttonEquals.setOnClickListener {
            val result = calculator.calculate()
            resultTextView.text = result.toString()
        }

        // 設置小數點按鈕的點擊事件
        buttonDecimal.setOnClickListener {
            calculator.appendDigit(".")
            resultTextView.text = calculator.getCurrentInput()
        }
    }
}