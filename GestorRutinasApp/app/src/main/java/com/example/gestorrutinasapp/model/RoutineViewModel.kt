package com.example.gestorrutinasapp.model

import android.text.Editable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gestorrutinasapp.model.exercice.Exercice
import com.example.gestorrutinasapp.model.exercice.ExerciceDao
import com.example.gestorrutinasapp.model.rutina.RoutineDao
import com.example.gestorrutinasapp.model.rutina.Rutina
import kotlinx.coroutines.launch


class RoutineViewModel(
    private val routineDao: RoutineDao,
    private val exerciceDao: ExerciceDao
) : ViewModel() {

    lateinit var  dayRoutine: Days
    lateinit var rutina:Rutina
    lateinit var selectedRutine : Rutina
    var allRoutines: List<Rutina> = emptyList()


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
    
    fun isEntryValid(itemName: Editable, day: Int): Boolean {
        if (itemName.isBlank() || day==null) {
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
        val newRoutine = getNewItemEntry(routineName, dayRoutine)
        insertRutina(newRoutine)
        rutina = newRoutine
    }

    fun addNewExercice(name:String,reps: Int,time: Int) {
        //selectedRutine= getRutinaByNameDay(rutina)
        val newRoutine = Exercice(name =name, repetitions =reps,time= time, id_routine =  selectedRutine.id)
        insertExercices(newRoutine)
    }





    private fun insertExercices(exercice: Exercice){
        viewModelScope.launch {
            exerciceDao.insert(exercice)
        }

    }

    private fun insertRutina(routine: Rutina){
        viewModelScope.launch {
            routineDao.insert(routine)
        }
    }

}

class RoutineViewModelFactory(private val routineDao: RoutineDao,private val exerciceDao: ExerciceDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RoutineViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RoutineViewModel(routineDao,exerciceDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")    }
}

