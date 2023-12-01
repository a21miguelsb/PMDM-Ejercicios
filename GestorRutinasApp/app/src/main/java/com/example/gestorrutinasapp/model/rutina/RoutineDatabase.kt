package com.example.gestorrutinasapp.model.rutina

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gestorrutinasapp.model.exercice.ExerciceDao
import com.example.gestorrutinasapp.model.exercice.ExerciceDatabase

@Database(entities = [RoutineEntity::class], version = 1)
abstract class RoutineDatabase: RoomDatabase() {
    abstract fun getRoutineDao(): RoutineDao

    companion object{
        @Volatile
        private var INSTANCE: RoutineDatabase? = null
        fun getDatabase(context: Context): RoutineDatabase {
            return  INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoutineDatabase::class.java,
                    "routine_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE=instance
                return instance
            }
        }
    }}