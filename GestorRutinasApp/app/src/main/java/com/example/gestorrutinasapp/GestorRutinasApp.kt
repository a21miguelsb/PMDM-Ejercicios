package com.example.gestorrutinasapp

import android.app.Application
import com.example.gestorrutinasapp.model.exercice.ExerciceDatabase
import com.example.gestorrutinasapp.model.rutina.RoutineDatabase
import dagger.hilt.android.HiltAndroidApp


class GestorRutinasApp: Application(){
    val databaseExercice: ExerciceDatabase by lazy{ExerciceDatabase.getDatabase(this)}
    val databaseRoutine: RoutineDatabase by lazy{RoutineDatabase.getDatabase(this)}
}
