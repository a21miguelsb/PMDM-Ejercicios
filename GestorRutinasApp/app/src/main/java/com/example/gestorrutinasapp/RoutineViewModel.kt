package com.example.gestorrutinasapp

import androidx.lifecycle.ViewModel
import com.example.gestorrutinasapp.clases.Days
import com.example.gestorrutinasapp.clases.Exercice
import com.example.gestorrutinasapp.clases.Rutina

class RoutineViewModel: ViewModel() {

    var listaRutinas = ArrayList<Rutina>()

    var routineName=""

    lateinit var  dayRoutine: Days
    fun setName(name: String){
        routineName = name
    }

    fun setDay(day: Int):Days{
        when(day){
            1->dayRoutine= Days.LUNES
            2->dayRoutine= Days.MARTES
            3->dayRoutine= Days.MIERCOLES
            4->dayRoutine= Days.JUEVES
            5->dayRoutine= Days.VIERNES
            6->dayRoutine= Days.SABADO
            7->dayRoutine= Days.DOMINGO
        }
        return dayRoutine
    }

    fun saveRutinas(nameRoutine: String,dayRoutine: Days ,exercices: List<Exercice>) {
        listaRutinas.add(Rutina(nameRoutine,dayRoutine,exercices))
    }



}

