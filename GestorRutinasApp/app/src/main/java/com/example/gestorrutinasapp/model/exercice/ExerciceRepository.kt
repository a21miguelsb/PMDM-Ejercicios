package com.example.gestorrutinasapp.model.exercice

import javax.inject.Inject

class ExerciceRepository @Inject constructor(
    private val exerciceDao: ExerciceDao

) {


    suspend fun getAllQuotesFromDatabase():List<Exercice>{
        val response = exerciceDao.getAllQuotes()
        return response
    }
}