package com.example.ejerciciolambda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputNumero = findViewById<EditText>(R.id.inputNumero)
        val btnComprobar = findViewById<Button>(R.id.btnComprobar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val esPrimo: (Int) -> Boolean = { n ->
            if (n < 2) false
            else (2..Math.sqrt(n.toDouble()).toInt()).none { n % it == 0 }
        }


        btnComprobar.setOnClickListener {
            val numero = inputNumero.text.toString().toIntOrNull()
            if (numero != null) {
                val resultado = esPrimo(numero)
                txtResultado.text = "¿Es primo? $resultado"
            } else {
                txtResultado.text = "Introduce un número válido"
            }

        }
    }
}