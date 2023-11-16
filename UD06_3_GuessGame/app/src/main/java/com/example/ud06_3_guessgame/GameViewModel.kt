package com.example.ud06_3_guessgame

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel:ViewModel() {
    val words = listOf("Android","Fragment","Kotlin","Model")
    var secretWord = words.random().uppercase()
}