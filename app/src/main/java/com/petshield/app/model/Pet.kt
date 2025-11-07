package com.petshield.app.model

data class Pet(
    val id: String = "",
    val ownerId: String = "",
    val name: String = "",
    val species: String = "",
    val breed: String = "",
    val ageMonths: Int = 0,
    val medicalHistory: String = "",
    val gpsTag: String = ""
)
