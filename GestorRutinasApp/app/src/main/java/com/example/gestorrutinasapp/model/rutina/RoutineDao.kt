package com.example.gestorrutinasapp.model.rutina

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.gestorrutinasapp.model.exercice.Exercice

@Dao
interface RoutineDao {
    @Query("SELECT * FROM routine_table ORDER BY name DESC ")
    suspend fun getAllQuotes():List<Rutina>

    @Query("SELECT * FROM routine_table Where id= :id ")
    suspend fun getRutina(id:Int):List<Rutina>

    @Upsert
    suspend fun insert(rutina: Rutina)
}