package com.petshield.app.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.petshield.app.databinding.ActivitySosBinding
import com.petshield.app.model.Alert
import com.petshield.app.data.FirestoreRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class SOSActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendAlert.setOnClickListener {
            val type = when (binding.rgStatus.checkedRadioButtonId) {
                binding.rbLost.id -> "Lost"
                binding.rbInjured.id -> "Injured"
                else -> "In Danger"
            }

            val uid = Firebase.auth.currentUser?.uid.orEmpty()
            val alert = Alert(
                id = "",
                petId = "", // optional placeholder
                type = type,
                timestamp = System.currentTimeMillis(),
                location = "Unknown"
            )

            lifecycleScope.launch {
                try {
                    FirestoreRepository.sendAlert(alert)
                    Toast.makeText(this@SOSActivity, "Alert sent successfully!", Toast.LENGTH_SHORT).show()
                    finish()
                } catch (ex: Exception) {
                    Toast.makeText(this@SOSActivity, "Error: ${ex.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
