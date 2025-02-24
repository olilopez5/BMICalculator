package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightEditText : EditText
    lateinit var weightEditText : EditText
    lateinit var calculateButton: Button
    lateinit var resultBMI : TextView

    lateinit var edadSlider : Slider
    lateinit var edadTextView: TextView



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
        resultBMI = findViewById(R.id.resultBMI)

        edadTextView = findViewById(R.id.edadTextView)
        edadSlider = findViewById(R.id.edadSlider)


        edadSlider.addOnChangeListener { slider, value, fromUser ->
            edadTextView.text = "${value.toInt()}"
        }

        

        calculateButton.setOnClickListener {
         val height = heightEditText.text.toString().toFloat()
            val weight = weightEditText.text.toString().toFloat()

            val result = weight / ((height/100).pow(2))
            resultBMI.text = "$result %"

            val category = when {
                result < 18.5 -> "Bajo peso"
                result in 18.5..24.9 -> "Peso normal"
                result in 25.0..29.9 -> "Sobrepeso"
                result in 30.0..34.9 -> "Obesidad (Grado 1)"
                result in 35.0..39.9 -> "Obesidad (Grado 2)"
                result >= 40.0 -> "Obesidad (Grado 3)"
                else -> "Valor inválido"
            }

        }

    }
}