package com.example.gestorrutinasapp.model

import android.content.Context
import androidx.room.Room
import com.example.gestorrutinasapp.model.exercice.ExerciceDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val EXERCICE_DATABASE_NAME = "exercice_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)= Room.databaseBuilder(context,
        ExerciceDatabase::class.java,EXERCICE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providesExerciceDao(db: ExerciceDatabase)= db.getExerciceDao()

}

