package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificação = findViewById<TextView>(R.id.tv_classificação)

        tvResult.text = result.toString()

        val classificação: String = if (result <= 18.5f) {
            "MAGREZA"
        } else if (result > 18.5f && result <= 24.9f) {
            "NORMAL"
        } else if (result > 25.0f && result <= 29.9) {
            "SOBREPESO"
        } else if (result > 30.0f && result <= 39.9) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }

        val (Classificação, color) = when {
            result < 18.5f -> "MAGREZA" to R.color.red
            result > 18.5f && result <= 24.9f -> "NORMAL" to R.color.green
            result > 25.0f && result <= 29.9f -> "SOBREPESO" to R.color.yellow
            result > 30.0f && result <= 39.9f -> "OBESIDADE" to R.color.red
            else -> "OBESIDADE GRAVE" to R.color.red
        }
        tvClassificação.text = classificação
        tvClassificação.setTextColor(ContextCompat.getColor(this, color))
    }
}