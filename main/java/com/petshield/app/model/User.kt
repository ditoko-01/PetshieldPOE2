package com.petshield.app.model

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val profileImageUrl: String = "" // optional, can leave empty
)
