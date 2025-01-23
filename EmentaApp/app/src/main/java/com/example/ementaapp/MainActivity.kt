package com.example.ementaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ementaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonPedir.setOnClickListener {

            // Captar a quantidade de cada produto

            var qntCafe:String
            var qntCha:String
            var qntNata:String
            var qntCroissant:String
            var qntLanche:String

            // Café
            if (binding.editQntCafe.text.toString().isEmpty()) {
                qntCafe = "0"
            } else {
                qntCafe = binding.editQntCafe.text.toString()
            }

            // Chá
            if (binding.editQntCha.text.toString().isEmpty()) {
                qntCha = "0"
            } else {
                qntCha = binding.editQntCha.text.toString()
            }

            // Nata
            if (binding.editQntNata.text.toString().isEmpty()) {
                qntNata = "0"
            } else {
                qntNata = binding.editQntNata.text.toString()
            }

            // Croissant
            if (binding.editQntCroissant.text.toString().isEmpty()) {
                qntCroissant ="0"
            } else {
                qntCroissant = binding.editQntCroissant.text.toString()
            }

            // Lanche
            if (binding.editQntLanche.text.toString().isEmpty()) {
                qntLanche = "0"
            } else {
                qntLanche= binding.editQntLanche.text.toString()
            }


            // Criar o Intent, passa desta Activity para a PrepararPedido
            val i:Intent = Intent(this, PrepararPedidoActivity::class.java)

            // Adicionar os extras
            i.putExtra("cafe", qntCafe)
            i.putExtra("cha", qntCha)
            i.putExtra("nata", qntNata)
            i.putExtra("croissant", qntCroissant)
            i.putExtra("lanche", qntLanche)

            startActivity(i)
        }

    }
}