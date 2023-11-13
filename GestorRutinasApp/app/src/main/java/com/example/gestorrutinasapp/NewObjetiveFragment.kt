package com.example.gestorrutinasapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow

class NewObjetiveFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_new_objetive, container, false)

        val tableLayout = view.findViewById<TableLayout>(R.id.tableLayout)
        val btnAddRow = view.findViewById<Button>(R.id.add_btn)

        // Configurar el listener para el botón
        btnAddRow.setOnClickListener {
            val newRow = TableRow(requireContext())
            // Add your views to the new row (e.g., EditText, TextView, etc.)
            val editText = EditText(requireContext())
            // Add other views as needed...

            newRow.addView(editText)
            // Add other views as needed...

            // Add the new row to the table layout
            tableLayout.addView(newRow)
        }

        return view
    }
}








