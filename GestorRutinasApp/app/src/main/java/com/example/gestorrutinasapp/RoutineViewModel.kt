package com.example.gestorrutinasapp

import androidx.lifecycle.ViewModel
import com.example.gestorrutinasapp.model.Days
import com.example.gestorrutinasapp.model.Exercice
import com.example.gestorrutinasapp.model.Rutina

class RoutineViewModel: ViewModel() {

    var listaRutinas = ArrayList<Rutina>()

    var routineName=""

    var add=false
    lateinit var  dayRoutine: Days
    fun setName(name: String){
        routineName = name
    }

    fun setDay(day: Int):Days{
        when(day){
            0->dayRoutine= Days.LUNES
            1->dayRoutine= Days.MARTES
            2->dayRoutine= Days.MIERCOLES
            3->dayRoutine= Days.JUEVES
            4->dayRoutine= Days.VIERNES
            5->dayRoutine= Days.SABADO
            6->dayRoutine= Days.DOMINGO
        }
        return dayRoutine
    }

    fun saveRutinas(nameRoutine: String,dayRoutine: Days ,exercices: List<Exercice>) {
        listaRutinas.add(Rutina(nameRoutine,dayRoutine,exercices))

    }



}

