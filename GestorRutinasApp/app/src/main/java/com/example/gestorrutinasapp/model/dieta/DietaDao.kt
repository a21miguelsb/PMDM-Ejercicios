package com.example.gestorrutinasapp.model.dieta

import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface DietaDao {
    @Query("SELECT * FROM exercice ORDER BY name DESC ")
    fun getAllDiets(): Flow<List<Dieta>>

    @Insert
    suspend fun insert(exercice: Dieta)


    @Query("SELECT * from exercice WHERE id = :id")
    fun getDietById(id: Int): Flow<Dieta>

}