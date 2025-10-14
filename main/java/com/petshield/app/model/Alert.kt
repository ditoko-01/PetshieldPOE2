package com.petshield.app.model

data class Alert(
    val id: String = "",
    val petId: String = "",
    val type: String = "", // Lost/Injured/In Danger
    val timestamp: Long = System.currentTimeMillis(),
    val location: String = "",
)


