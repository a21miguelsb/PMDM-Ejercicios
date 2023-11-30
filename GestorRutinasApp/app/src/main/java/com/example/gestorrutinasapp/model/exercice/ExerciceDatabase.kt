package com.example.gestorrutinasapp.model.exercice

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ExerciceEntity::class], version = 1)
abstract class ExerciceDatabase: RoomDatabase() {
    abstract fun getExerciceDao(): ExerciceDao
}