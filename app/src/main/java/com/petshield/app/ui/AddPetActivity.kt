package com.petshield.app.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.petshield.app.databinding.ActivityAddPetBinding
import com.petshield.app.model.Pet
import com.petshield.app.data.FirestoreRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class AddPetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegisterPet.setOnClickListener {
            val name = binding.etPetName.text.toString().trim()
            val species = binding.etSpecies.text.toString().trim()
            val breed = binding.etBreed.text.toString().trim()
            val ageText = binding.etAge.text.toString().trim()
            val medHistory = binding.etMedHistory.text.toString().trim()

            if (name.isEmpty() || species.isEmpty() || breed.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ageMonths = ageText.toIntOrNull() ?: 0
            val uid = Firebase.auth.currentUser?.uid.orEmpty()

            val pet = Pet(
                id = "",
                ownerId = uid,
                name = name,
                species = species,
                breed = breed,
                ageMonths = ageMonths,
                medicalHistory = medHistory,
                gpsTag = "" // optional; can be set later
            )

            lifecycleScope.launch {
                try {
                    FirestoreRepository.addPet(pet)
                    Toast.makeText(this@AddPetActivity, "Pet added successfully!", Toast.LENGTH_SHORT).show()
                    finish() // Return to DashboardActivity
                } catch (ex: Exception) {
                    Toast.makeText(this@AddPetActivity, "Error: ${ex.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
