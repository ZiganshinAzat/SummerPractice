 package com.example.testapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

 class MainActivity : AppCompatActivity() {

     private var name: EditText? = null
     private var height: EditText? = null
     private var weight: EditText? = null
     private var age: EditText? = null
     private var bodyMassIndexButton: Button? = null
     private var responseField: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editTextText)
        height = findViewById(R.id.editTextNumber)
        weight = findViewById(R.id.editTextNumberDecimal)
        age = findViewById(R.id.editTextNumber2)
        bodyMassIndexButton = findViewById((R.id.button))
        responseField = findViewById(R.id.textView)

        bodyMassIndexButton?.setOnClickListener {
            val nameText = name?.text.toString()
            val heightValue = height?.text.toString().toIntOrNull()
            val weightValue = weight?.text.toString().toFloatOrNull()
            val ageValue = age?.text.toString().toIntOrNull()

            if (nameText.isNotBlank() && nameText.length <= 50 &&
                heightValue in 0..250 && heightValue != null &&
                weightValue != null && weightValue >= 0f && weightValue <= 250f &&
                ageValue != null && ageValue in 0..150
            ) {
                val heightInMeters = heightValue / 100f
                val bmi = weightValue / (heightInMeters * heightInMeters)
                responseField?.text = "Ответ: $bmi"
            }
            else {
                responseField?.text = "Данные введены некорректно."
            }
        }


    }
}