package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TableRow

class NewObjetiveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_objetive, container, false)

        val spinnerDays = view.findViewById<Spinner>(R.id.spinner_dias)
        spinnerDays

        return view
    }
}








