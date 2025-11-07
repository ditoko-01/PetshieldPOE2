package com.petshield.app.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.petshield.app.databinding.ActivityProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = Firebase.auth.currentUser
        binding.tvName.text = user?.email ?: "Guest"

        binding.btnChangePassword.setOnClickListener {
            val email = user?.email
            if (email != null) {
                Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener {
                    if (it.isSuccessful) Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this, "Failed: ${it.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnAccountDetails.setOnClickListener {
            Toast.makeText(this, "Account details screen (to implement)", Toast.LENGTH_SHORT).show()
        }
    }
}
