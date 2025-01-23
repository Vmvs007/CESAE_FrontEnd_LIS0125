package com.example.ementaapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.ementaapp.databinding.ActivityPrepararPedidoBinding

class PrepararPedidoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityPrepararPedidoBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        val qntCha = i.extras?.getString("cha")
        val qntNata = i.extras?.getString("nata")
        val qntCroissant = i.extras?.getString("croissant")
        val qntLanche = i.extras?.getString("lanche")

        // Podemos fazer diretamente na mesma linha

        val i2 = Intent(this,PedidoFinalActivity::class.java)
        i2.putExtra("cafe", i.extras?.getString("cafe"))

        // Podemos usar variáveis intermédias
        i2.putExtra("cha", qntCha)
        i2.putExtra("nata", qntNata)
        i2.putExtra("croissant", qntCroissant)
        i2.putExtra("lanche", qntLanche)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(i2)
            finish()
        },2000)
    }
}