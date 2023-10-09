package com.example.ud02_4_practicalayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nombre=findViewById<TextView>(R.id.Nombre)
        val llamadaText="LLamando a "
        val button=findViewById<Button>(R.id.button)
        val textView4 = findViewById<TextView>(R.id.textView4)

        button.setOnClickListener{
            textView4.text=llamadaText+nombre.text
        }
    }
    }

