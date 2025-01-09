package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCumprimentar.setOnClickListener {

            var nomeUser: String = binding.editNome.text.toString()
            binding.textCumprimentarUser.text = "Olá $nomeUser"

        }

    }
}