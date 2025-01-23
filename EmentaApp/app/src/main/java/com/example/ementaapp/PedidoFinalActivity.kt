package com.example.ementaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ementaapp.databinding.ActivityPedidoFinalBinding

class PedidoFinalActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPedidoFinalBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        val qntCafe = i.extras?.getString("cafe")
        val qntCha = i.extras?.getString("cha")
        val qntNata = i.extras?.getString("nata")
        val qntCroissant = i.extras?.getString("croissant")
        val qntLanche = i.extras?.getString("lanche")

        // Trocamos os textviews para a quantidade certa
        binding.textQntCafe.text = "$qntCafe"
        binding.textQntCha.text = "$qntCha"
        binding.textQntNata.text = "$qntNata"
        binding.textQntCroissant.text = "$qntCroissant"
        binding.textQntLanche.text = "$qntLanche"

        var totalPedido: Double = 0.0

        if (qntCafe != null && qntCha != null && qntNata != null && qntCroissant != null && qntLanche != null) {
            totalPedido =
                (qntCafe.toDouble() * 1.0) + (qntCha.toDouble() * 1.5) + (qntNata.toDouble() * 0.9) + (qntCroissant.toDouble() * 0.9) + (qntLanche.toDouble() * 2.5)
        }

        binding.textValorFinal.text = "Total Pedido: $totalPedido €"

    }
}