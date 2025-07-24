package com.example.socialmedia

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.socialmedia.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SignUpTV.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
        binding.LoginBtn.setOnClickListener {
            validation()
        }

    }

    private fun validation() {

        val email = binding.TIET2.text.toString().trim()
        val password = binding.TIET3.text.toString().trim()

        if (email.isEmpty()) {
            binding.TIET2.hint = "Please enter your email"
            binding.TIET2.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }
        if (password.isEmpty()) {
            binding.TIET3.hint = "Please enter your password"
            binding.TIET3.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }
        startActivity(Intent(this, MainActivity::class.java))
    }
}