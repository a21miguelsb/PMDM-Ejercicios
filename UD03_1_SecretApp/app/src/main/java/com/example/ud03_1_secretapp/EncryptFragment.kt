package com.example.ud03_1_secretapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class EncryptFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mensaje =EncryptFragmentArgs.fromBundle(requireArguments()).mensaje
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        view.findViewById<TextView>(R.id.encrypt_textValue).text = cifrado(mensaje)
        return view
    }

    fun cifrado(mensaje : String) = mensaje.uppercase().map() {
        var letra = it.code.plus(3)
        letra.toChar()
        return@map

    }

}