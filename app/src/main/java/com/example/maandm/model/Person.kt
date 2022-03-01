package com.example.maandm.model

import java.io.Serializable

data class Person(
    var image: Int,
    var name: String,
    var about: String,
    var x: Double,
    var y: Double
) : Serializable
