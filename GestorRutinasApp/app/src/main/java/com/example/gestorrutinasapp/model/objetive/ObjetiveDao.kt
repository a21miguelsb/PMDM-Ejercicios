package com.example.gestorrutinasapp.model.objetive

import androidx.room.Insert
import androidx.room.Query
import com.example.gestorrutinasapp.model.Days
import kotlinx.coroutines.flow.Flow

interface ObjetiveDao{
    @Query("SELECT * FROM rutina_database")
    fun getAllObjetives(): Flow<List<Objetive>>

    @Query("SELECT * FROM rutina_database Where name= :name and day = :day ")
    suspend fun getObjetiveById(name: String,day: Days): Objetive

    @Insert
    suspend fun insert(rutina: Objetive)
}