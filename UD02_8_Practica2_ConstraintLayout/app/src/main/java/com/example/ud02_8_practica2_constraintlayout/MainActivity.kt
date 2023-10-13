package com.example.ud02_8_practica2_constraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val itemList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textoTarea = findViewById<EditText>(R.id.txtTarea)
        val  btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val  lista = findViewById<ListView>(R.id.lista)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        lista.adapter=adapter
        btnAgregar.setOnClickListener {
        itemList.add(textoTarea.text.toString())
            textoTarea.text = null
            adapter.notifyDataSetChanged()

        }


    }
}