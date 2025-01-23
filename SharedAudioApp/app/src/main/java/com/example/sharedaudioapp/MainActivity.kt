package com.example.sharedaudioapp

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedaudioapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Trazer o audio para a nossa aplicação
        val mediaPlayerSuperMario = MediaPlayer.create(applicationContext,R.raw.super_mario_coin)


        // Para ir buscar os shared preferences que já estavam guardados
        val sharedPreferences = this.getSharedPreferences("nome", Context.MODE_PRIVATE)
        var nomeUtilizador= sharedPreferences.getString("nome","Utilizador").toString()

        binding.textCumprimento.text="Olá $nomeUtilizador"

        binding.buttonCumprimentar.setOnClickListener {

            mediaPlayerSuperMario.start()

            var nomeLido:String = binding.editNome.text.toString()

            // Para guardar novos valores no shared preferences
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("nome",nomeLido)
            editor.apply()

            binding.textCumprimento.text="Olá $nomeLido"
        }

    }
}