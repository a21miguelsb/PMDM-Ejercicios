package com.example.gestorrutinasapp

import android.text.Editable
import androidx.lifecycle.ViewModel

class RoutineViewModel: ViewModel() {

    var numEjercicios =5

    fun changeNumEx(number: Int){
        numEjercicios = number
    }

}

