package com.petshield.app

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.auth.ktx.auth


class PetShieldApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Firebase initializes automatically when google-services.json is present.
        // Optional: setup FCM topic subscription for demo
        Firebase.messaging.isAutoInitEnabled = true
    }
}
