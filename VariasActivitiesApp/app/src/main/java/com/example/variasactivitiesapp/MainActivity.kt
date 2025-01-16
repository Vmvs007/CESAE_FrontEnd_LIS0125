package com.example.variasactivitiesapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.variasactivitiesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonAvancarSegunda.setOnClickListener{

            // Trocar para a Second Activity
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        }

        binding.buttonAvancarTerceira.setOnClickListener{

            // Trocar para a Third Activity
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)

        }
    }
}