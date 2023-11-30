package com.example.gestorrutinasapp.model

import com.example.gestorrutinasapp.model.exercice.Exercice
import javax.inject.Inject

class Rutina @Inject constructor(
    var name: String,
    var day: Days,
    var exercices: List<Exercice>
) {


}