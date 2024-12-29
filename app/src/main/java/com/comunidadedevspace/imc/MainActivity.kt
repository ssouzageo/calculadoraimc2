package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<TextInputEditText>(R.id.edtpeso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edtaltura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos.",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaq2 = altura * altura
                val resultado = peso / alturaq2

                // 1. Mostrar resultado na outra tela;
                // 2. Criar layout da tela result;
                // 3. Passar dados para a outra tela; e
                // Bônus: Intent é uma classe do android que serve para declarar intenções no sistema.

                val intent = Intent (this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)

                println("Geo ação do botão " + resultado)
            }


        }
    }
}