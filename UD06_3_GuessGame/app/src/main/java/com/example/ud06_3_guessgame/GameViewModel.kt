package com.example.ud06_3_guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel:ViewModel() {
    val words = listOf("Android","Fragment","Kotlin","Model")
    var secretWord = words.random().uppercase()

    var secretWordDisplay =MutableLiveData<String>()
    var lives=MutableLiveData<Int>(5)
    var guesses = mutableListOf<Char>()

init{
    secretWordDisplay.value = generateWordDisplay()
}
    fun generateWordDisplay()=
        secretWord.map {
            if (it in guesses) it else "-"
        }.joinToString("")

    fun game(guess: Char){
        guesses.add(guess.uppercaseChar())
        secretWordDisplay.value = generateWordDisplay()
        if (!secretWord.contains(guess.uppercaseChar())) lives.value?.toInt()?.minus(1)
    }
    fun win()= secretWordDisplay.equals(secretWord)
    fun lost()=lives.value?:0 <= 0
    fun resultMessage() =
        if (win())"Has ganado"
        else "Has perdido"


    fun restart(){
        guesses.clear()
        lives = MutableLiveData<Int>(5)
        secretWord = words.random().uppercase()
        secretWordDisplay.value = generateWordDisplay()
    }
}