package com.example.gestorrutinasapp.model.exercice

import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ExerciceDao {
    @Query("SELECT * FROM exercice ORDER BY name DESC ")
    fun getAllQuotes(): Flow<List<Exercice>>

    @Upsert
    fun insert(exercice: Exercice)


    @Query("SELECT * from exercice WHERE id = :id")
    fun getItem(id: Int): Flow<Exercice>


}