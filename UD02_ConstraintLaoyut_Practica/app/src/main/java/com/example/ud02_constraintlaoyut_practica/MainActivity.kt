package com.example.ud02_constraintlaoyut_practica

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bntLogin = findViewById<Button>(R.id.btnLogin)
        val username = findViewById<EditText>(R.id.user).text
        val password = findViewById<EditText>(R.id.password).text
        bntLogin.setOnClickListener {
            findViewById<TextView>(R.id.text).text = "Usuario: "+username +" Contraseña: "+password
        }
    }
}