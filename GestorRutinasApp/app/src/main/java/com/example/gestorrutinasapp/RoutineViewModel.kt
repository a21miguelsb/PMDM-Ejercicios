package com.example.gestorrutinasapp

import android.text.Editable
import androidx.lifecycle.ViewModel

class RoutineViewModel: ViewModel() {

    var numEjercicios =5



    fun changeNumEx(number: Int){
        numEjercicios = number
    }


    fun createRutinas(name: String, reps: Int, time: Int){
        val rutina = Exercice(name,reps,time)

    }
}

