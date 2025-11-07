package com.petshield.app.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.petshield.app.data.FirestoreRepository
import com.petshield.app.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var adapter: PetsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = Firebase.auth.currentUser
        binding.tvWelcome.text = "Welcome, ${user?.email ?: "User"}"

        // --- FCM Token Retrieval ---
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val token = task.result
                Log.d("FCM", "Device Token: $token")
            } else {
                Log.e("FCM", "Fetching FCM token failed", task.exception)
            }
        }

        // Button listeners
        binding.btnAddPet.setOnClickListener { startActivity(Intent(this, AddPetActivity::class.java)) }
        binding.btnCommunity.setOnClickListener { startActivity(Intent(this, CommunityActivity::class.java)) }
        binding.btnProfile.setOnClickListener { startActivity(Intent(this, ProfileActivity::class.java)) }

        // RecyclerView
        adapter = PetsAdapter()
        binding.rvPets.layoutManager = LinearLayoutManager(this)
        binding.rvPets.adapter = adapter

        loadPets()
    }

    override fun onResume() {
        super.onResume()
        loadPets()
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
