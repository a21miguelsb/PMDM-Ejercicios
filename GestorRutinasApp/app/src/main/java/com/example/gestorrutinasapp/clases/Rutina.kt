package com.example.gestorrutinasapp.clases

class Rutina {
    var name: String
    var day: Days
    var exercices: List<Exercice>
    constructor(name: String, day: Days, exercices: List<Exercice>) {
        this.name = name
        this.day = day
        this.exercices = exercices
    }
}