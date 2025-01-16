package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener{

            var usernameInserido:String = binding.editUsername.text.toString()
            var passwordInserida:String = binding.editPassword.text.toString()

            if(usernameInserido.equals("user") && passwordInserida.equals("pass")){ // Login Válido

                val intent = Intent(this,LoginOkActivity::class.java)
                startActivity(intent)

            }else{ // Login Inválido

                val intent = Intent(this,LoginErradoActivity::class.java)
                startActivity(intent)

            }

        }

    }
}