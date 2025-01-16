package com.example.loginlinearapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginlinearapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonLogin.setOnClickListener {

            var usernameInserido:String = binding.editUsername.text.toString()
            var passwordInserida:String = binding.editPassword.text.toString()

            if(usernameInserido.equals("user") && passwordInserida.equals("pass")){ // Login válido

                Toast.makeText(applicationContext, "LOGIN EFETUADO", Toast.LENGTH_SHORT).show()

            }else{ // Login inválido

                Toast.makeText(applicationContext, "LOGIN INVÁLIDO", Toast.LENGTH_SHORT).show()
            }

            // Limpar ambos os campos
            binding.editUsername.setText("")
            binding.editPassword.setText("")

        }



    }
}