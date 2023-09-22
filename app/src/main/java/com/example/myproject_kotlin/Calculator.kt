package com.example.myproject_kotlin

class Calculator {
    private var currentInput: String = ""
    private var currentOperator: String = ""
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0

    fun appendDigit(digit: String) {
        currentInput += digit
    }

    fun appendDigit(digit: Int) {
        currentInput += digit.toString()
    }

    fun setOperator(operator: String) {
        if (currentInput.isNotEmpty()) {
            currentOperator = operator
            operand1 = currentInput.toDouble()
            currentInput = ""
        }
    }

    fun calculate(): Any {
        if (currentInput.isNotEmpty() && currentOperator.isNotEmpty()) {
            operand2 = currentInput.toDouble()
            val result = when (currentOperator) {
                "+" -> operand1 + operand2
                "-" -> operand1 - operand2
                "*" -> operand1 * operand2
                "/" -> {
                    if (operand2 != 0.0) {
                        operand1 / operand2
                    } else {
                        // Handle division by zero
                        return Double.NaN
                    }
                }
                else -> return Double.NaN
            }

            // 清除當前輸入
            currentInput = ""

            // 根據小數點的長度判斷是否使用科學符號
            val resultString = if (result.isNaN() || !result.isFinite()) {
                "Error"
            } else {
                val resultFormatted = if (result % 1 == 0.0) {
                    result.toInt().toString()
                } else {
                    val resultStr = result.toString()
                    if (resultStr.length > 8) {
                        String.format("%.2e", result)
                    } else {
                        resultStr
                    }
                }
                resultFormatted
            }

            return resultString
        }
        return Double.NaN
    }

    fun getCurrentInput(): String {
        return currentInput
    }

    fun clear() {
        currentInput = ""
        currentOperator = ""
        operand1 = 0.0
        operand2 = 0.0
    }
}