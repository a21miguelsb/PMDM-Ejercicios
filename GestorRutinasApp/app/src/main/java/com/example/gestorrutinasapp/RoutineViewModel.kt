package com.example.gestorrutinasapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gestorrutinasapp.model.Days
import com.example.gestorrutinasapp.model.exercice.Exercice
import com.example.gestorrutinasapp.model.exercice.ExerciceDao
import com.example.gestorrutinasapp.model.rutina.Rutina
import com.example.gestorrutinasapp.model.rutina.RoutineDatabase

import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.gestorrutinasapp.model.rutina.RoutineDao


class RoutineViewModel(
    private val routineDao: RoutineDao,
    ) : ViewModel() {



    private fun insertExercices(routine: Rutina){
        viewModelScope.launch {
                routineDao.insert(routine)
            }

    }

    var routineName=""



    lateinit var routineInfo: Rutina
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



    fun isEntryValid(itemName: String, day: Int): Boolean {
        if (itemName.isBlank() || day!=null) {
            return false
        }
        return true
    }

    private fun getNewItemEntry(name: String, day: Int): Rutina {
        return Rutina(
            name = name,
            day = setDay(day),
        )
    }
    fun addNewRoutine(routineName: String, dayRoutine: Int) {
        val newItem = getNewItemEntry(routineName, dayRoutine)
        insertExercices(newItem)
    }




}

class RoutineViewModelFactory(private val routineDao: RoutineDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoutineViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RoutineViewModel(routineDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")    }
}

