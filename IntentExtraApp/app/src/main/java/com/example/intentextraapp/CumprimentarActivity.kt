package com.example.intentextraapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentextraapp.databinding.ActivityCumprimentarBinding

class CumprimentarActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityCumprimentarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        var nomeUser = i.extras?.getString("nomeInserido")

        if(nomeUser.equals("")){
            binding.textCumprimentar.text="Olá Utilizador"
        }else{
            binding.textCumprimentar.text="Olá $nomeUser"
        }


    }
}