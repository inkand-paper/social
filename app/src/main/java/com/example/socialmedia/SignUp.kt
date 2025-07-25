package com.example.socialmedia

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.socialmedia.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebase: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginTV.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
        }

        binding.SignUpBtn.setOnClickListener {
            validation()
        }

    }

    private fun validation() {
        val name = binding.TIET1.text.toString().trim()
        val email = binding.TIET2.text.toString().trim()
        val password = binding.TIET3.text.toString().trim()
        val confirmPassword = binding.TIET4.text.toString().trim()

        if (name.isEmpty()) {
            binding.TIET1.hint = "Please enter your name"
            binding.TIET1.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }
        if (email.isEmpty()) {
            binding.TIET2.hint = "Please enter your email"
            binding.TIET2.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }
        if (password.isEmpty()) {
            binding.TIET3.hint = "Please enter your password"
            binding.TIET3.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }
        if (confirmPassword.isEmpty()) {
            binding.TIET4.hint = "Please enter your password"
            binding.TIET4.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
        }
        startActivity(Intent(this, MainActivity::class.java))
    }
}


