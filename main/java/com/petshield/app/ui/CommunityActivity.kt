package com.petshield.app.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.petshield.app.databinding.ActivityCommunityBinding

class CommunityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommunityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommunityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPost.setOnClickListener {
            val msg = binding.etMessage.text.toString().trim()
            if (msg.isEmpty()) {
                Toast.makeText(this, "Enter a message", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // For prototype just append to TextView. In production, push to Firestore "posts" collection.
            binding.tvFeed.append("\n• $msg")
            binding.etMessage.text.clear()
            Toast.makeText(this, "Posted", Toast.LENGTH_SHORT).show()
        }
    }
}
