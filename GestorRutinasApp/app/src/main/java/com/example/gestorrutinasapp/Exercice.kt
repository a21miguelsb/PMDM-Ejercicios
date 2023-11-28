package com.example.gestorrutinasapp

class Exercice {
    var name: String
        get() {
            return name
        }
        set(value) {
            name =value
        }

    var repetitions: Int
        get() {
            return repetitions
        }
        set(value) {
            repetitions=value
        }

    var time: Int
        get() {
            return time
        }
        set(value) {
            time=value
        }

    constructor(name: String, repetitions: Int, time: Int) {
        this.name = name
        this.repetitions = repetitions
        this.time = time
    }
}