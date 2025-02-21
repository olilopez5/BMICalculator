package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightEditText : EditText
    lateinit var weightEditText : EditText
    lateinit var calculateButton: Button
    lateinit var resultIMC : TextView






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //R. Res Vistas
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        calculateButton = findViewById(R.id.calculateButton)
        resultIMC = findViewById(R.id.resultIMC)


        calculateButton.setOnClickListener {
         val height = heightEditText.text.toString().toFloat()
            val weight = weightEditText.text.toString().toFloat()

            val result = weight / ((height/100).pow(2))
            resultIMC.text = "IMC: $result %"

        }
    }
}