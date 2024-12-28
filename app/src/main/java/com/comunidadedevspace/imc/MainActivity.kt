package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Recuperar os componentes EditText;
        // 2. Criar uma varíavel e recupera um componente de UI <EditText>
        // 3. Recuperar o botão da tela;
        // 4. Colocar ação do botão;
        // 5. Recuperar o texto dgitado nos edts; e


        val edtPeso = findViewById<TextInputEditText>(R.id.edtpeso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edtaltura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                // 6. Mostrar mensagem para o usuário.

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

                println("Geo ação do botão " + resultado)
            }


        }
    }
}