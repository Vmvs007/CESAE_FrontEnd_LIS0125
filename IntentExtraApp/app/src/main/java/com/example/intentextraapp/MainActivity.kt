package com.example.intentextraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentextraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonAvancar.setOnClickListener {

            var nomeInserido: String = binding.editNome.text.toString()


            // Passar entre Activities
            val i = Intent(this, CumprimentarActivity::class.java)

            // Estou a passar o nomeInserido por Extra, com a tag "nomePassado"
            i.putExtra("nomeInserido",nomeInserido)
            startActivity(i)

        }

    }
}