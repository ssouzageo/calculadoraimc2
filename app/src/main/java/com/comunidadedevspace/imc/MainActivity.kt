package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Recuperar os componentes EditText;
        // 2. Criar uma varíavel e recupera um componente de UI <EditText>
        // 3. Recuperar o botão da tela;
        // 4. Colocar ação do botão;
        // 5. Recuperar o texto dgitado nos edts.


        val edtPeso = findViewById<TextInputEditText>(R.id.edtpeso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edtaltura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val peso: Float = edtPeso.text.toString().toFloat()
            val altura: Float = edtAltura.text.toString().toFloat()

            val alturaq2 = altura * altura
            val resultado = peso / alturaq2

            println("Geo ação do botão " + resultado)
        }
    }
}