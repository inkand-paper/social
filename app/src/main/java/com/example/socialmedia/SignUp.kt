package com.example.socialmedia

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        firebase = FirebaseAuth.getInstance()
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
            return
        }else{
            if (email.isEmpty()) {
                binding.TIET2.hint = "Please enter your email"
                binding.TIET2.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
                return
            }
            else{
                if (password.isEmpty()) {
                    binding.TIET3.hint = "Please enter your password"
                    binding.TIET3.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
                    return
                }
                else{
                    if (confirmPassword.isEmpty()) {
                        binding.TIET4.hint = "Please enter your password"
                        binding.TIET4.setHintTextColor(ContextCompat.getColor(this, R.color.holo_red_dark))
                        return
                    }
                }
            }
        }
        firebase.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if (task.isSuccessful){
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, task.exception?.message?: "Account creation failed", Toast.LENGTH_SHORT).show()
                return@addOnCompleteListener
            }

        }


    }
}


