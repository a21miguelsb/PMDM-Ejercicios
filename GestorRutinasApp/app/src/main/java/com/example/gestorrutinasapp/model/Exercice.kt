package com.example.gestorrutinasapp.model

class Exercice {
    var name: String
    var repetitions: Int
    var time: Int


    constructor(name: String, repetitions: Int, time: Int) {
        this.name = name
        this.repetitions = repetitions
        this.time = time
    }
}