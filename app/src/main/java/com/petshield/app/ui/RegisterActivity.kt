package com.petshield.app.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.petshield.app.data.FirestoreRepository
import com.petshield.app.databinding.ActivityRegisterBinding
import com.petshield.app.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPassword.text.toString()

            // Basic validation
            if (name.isEmpty() || email.isEmpty() || pass.length < 6) {
                Toast.makeText(
                    this,
                    "Please fill all fields (Password must be at least 6 characters)",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Firebase Auth: Create user
            Firebase.auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val uid = Firebase.auth.currentUser!!.uid
                        val user = User(uid, name, email, "")

                        // Save user to Firestore
                        lifecycleScope.launch {
                            try {
                                FirestoreRepository.saveUser(user)
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Registered successfully",
                                    Toast.LENGTH_SHORT
                                ).show()
                                // Go to Dashboard
                                startActivity(Intent(this@RegisterActivity, DashboardActivity::class.java))
                                finish()
                            } catch (e: Exception) {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Error saving user: ${e.message}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    } else {
                        // Registration failed
                        Toast.makeText(
                            this,
                            "Register failed: ${task.exception?.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

        // Optional: Navigate to LoginActivity
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
