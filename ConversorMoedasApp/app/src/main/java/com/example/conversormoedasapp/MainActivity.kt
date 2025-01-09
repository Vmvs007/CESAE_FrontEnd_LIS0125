package com.example.conversormoedasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversormoedasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener{

            // Capturar o valor em euros que está no Edit Text
            var valorEuros: Double = binding.editEuros.text.toString().toDouble()

            // Converter o valor em euros para dolares
            val valorDolares: Double = String.format("%.2f", valorEuros * 1.1).toDouble()

            // Mostrar no TextView o valor em dolares
            binding.textDolares.text = "$valorDolares $"
        }

    }
}