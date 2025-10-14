package com.petshield.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.petshield.app.databinding.ActivityDashboardBinding
import com.petshield.app.model.Pet
import com.petshield.app.data.FirestoreRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: PetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = Firebase.auth.currentUser
        binding.tvWelcome.text = "Welcome, ${user?.email ?: "User"}"

        binding.btnAddPet.setOnClickListener {
            startActivity(Intent(this, AddPetActivity::class.java))
        }

        binding.btnCommunity.setOnClickListener {
            startActivity(Intent(this, CommunityActivity::class.java))
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        adapter = PetsAdapter()
        binding.rvPets.layoutManager = LinearLayoutManager(this)
        binding.rvPets.adapter = adapter

        loadPets() // initial load
    }

    override fun onResume() {
        super.onResume()
        loadPets() // refresh when returning from AddPetActivity
    }

    private fun loadPets() {
        val uid = Firebase.auth.currentUser?.uid ?: return
        lifecycleScope.launch {
            try {
                val pets = FirestoreRepository.getPetsForUser(uid)
                adapter.submitList(pets)
            } catch (ex: Exception) {
                Toast.makeText(this@DashboardActivity, "Error loading pets: ${ex.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
