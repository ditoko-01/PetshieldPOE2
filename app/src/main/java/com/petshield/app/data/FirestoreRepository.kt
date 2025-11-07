package com.petshield.app.data

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.petshield.app.model.User
import com.petshield.app.model.Pet
import com.petshield.app.model.Alert
import kotlinx.coroutines.tasks.await

object FirestoreRepository {

    private val db = FirebaseFirestore.getInstance()
    private val usersCollection = db.collection("users")
    private val petsCollection = db.collection("pets")
    private val alertsCollection = db.collection("alerts")

    // Save a user to Firestore
    suspend fun saveUser(user: User) {
        try {
            usersCollection.document(user.uid).set(user).await()
            Log.d("Firestore", "User saved: ${user.uid}")
        } catch (e: Exception) {
            Log.e("Firestore", "Error saving user", e)
            throw e
        }
    }

    // Get a user by UID
    suspend fun getUser(uid: String): User? {
        return try {
            val snapshot = usersCollection.document(uid).get().await()
            snapshot.toObject(User::class.java)
        } catch (e: Exception) {
            Log.e("Firestore", "Error fetching user", e)
            null
        }
    }

    // Add a Pet
    suspend fun addPet(pet: Pet) {
        try {
            val docRef = petsCollection.document() // auto-generate ID
            val petWithId = pet.copy(id = docRef.id)
            docRef.set(petWithId).await()
            Log.d("Firestore", "Pet added: ${petWithId.id}")
        } catch (e: Exception) {
            Log.e("Firestore", "Error adding pet", e)
            throw e
        }
    }

    // Get Pets for a User
    suspend fun getPetsForUser(ownerId: String): List<Pet> {
        return try {
            val snapshot = petsCollection.whereEqualTo("ownerId", ownerId).get().await()
            snapshot.toObjects(Pet::class.java)
        } catch (e: Exception) {
            Log.e("Firestore", "Error fetching pets for user: $ownerId", e)
            emptyList()
        }
    }

    // Send an Alert
    suspend fun sendAlert(alert: Alert) {
        try {
            val docRef = alertsCollection.document() // auto-generate ID
            val alertWithId = alert.copy(id = docRef.id)
            docRef.set(alertWithId).await()
            Log.d("Firestore", "Alert sent: ${alertWithId.id}")
        } catch (e: Exception) {
            Log.e("Firestore", "Error sending alert", e)
            throw e
        }
    }

    // Save an alert (alias for sendAlert, keeping method for clarity)
    suspend fun saveAlert(alert: Alert) {
        sendAlert(alert)
    }
}
