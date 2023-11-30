package com.example.gestorrutinasapp.model.exercice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercice_table")
data class ExerciceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int=0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "repetitions") val repetitions: String,
    @ColumnInfo(name = "time") val time: String,
)
