package com.example.gestorrutinasapp.model.exercice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Exercice::class], version = 1)
abstract class ExerciceDatabase: RoomDatabase() {
    abstract fun exerciceDao(): ExerciceDao

    companion object{
        @Volatile
        private var INSTANCE: ExerciceDatabase? = null
        fun getDatabase(context: Context): ExerciceDatabase{
            return  INSTANCE?: synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExerciceDatabase::class.java,
                        "exercice_database"
                    ).fallbackToDestructiveMigration().build()
                INSTANCE=instance
                return instance
            }
        }
    }
}