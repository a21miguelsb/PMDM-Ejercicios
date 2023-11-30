package com.example.gestorrutinasapp.model.exercice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciceDao {
    @Query("SELECT * FROM exercice_table ORDER BY name DESC ")
    suspend fun getAllQuotes():List<Exercice>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll():List<Exercice>




}