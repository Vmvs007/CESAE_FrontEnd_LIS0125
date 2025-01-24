package com.example.onlinestoreapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinestoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mediaPlayerCash = MediaPlayer.create(applicationContext,R.raw.cash)
        val mediaPlayerBooo = MediaPlayer.create(applicationContext,R.raw.booo)


        var valorTotalCarrinho: Double = 0.0
        var pesoTotalCarrinho: Double = 0.0

        // Criar a lista de produtos do catalogo
        val listaCatalogo = ArrayList<Produto>()
        listaCatalogo.add(Produto("Smartphone", "iPhone 11", 900.0, 0.2))
        listaCatalogo.add(Produto("Smartphone", "iPhone 12", 1100.0, 0.22))
        listaCatalogo.add(Produto("Smartphone", "iPhone 15", 1500.0, 0.24))

        listaCatalogo.add(Produto("Laptop", "HP 15 XPTO", 500.0, 1.2))

        listaCatalogo.add(Produto("Periferico", "Rato Logitech", 90.0, 0.1))
        listaCatalogo.add(Produto("Periferico", "Teclado Logitech", 100.0, 0.3))

        listaCatalogo.add(Produto("Desktop", "Dell 17.3 XPTO", 2000.0, 3.1))
        listaCatalogo.add(Produto("Desktop", "Lenovo 15.6 XPTO", 1500.0, 3.1))

        listaCatalogo.add(Produto("Componentes", "Disco SSD 1TB", 190.0, 0.05))
        listaCatalogo.add(Produto("Componentes", "Disco SSD 2TB", 290.0, 0.05))
        listaCatalogo.add(Produto("Componentes", "Memória 4x8GB DDR5", 300.0, 0.02))

        val listaCarrinho = ArrayList<Produto>()

        val arrayAdapterCatalogo =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCatalogo)
        binding.listViewCatalogo.adapter = arrayAdapterCatalogo

        var arrayAdapterCarrinho =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCarrinho)
        binding.listViewCarrinho.adapter = arrayAdapterCarrinho

        binding.listViewCatalogo.setOnItemClickListener { parent, view, position, id ->

            mediaPlayerCash.start()

            var produtoComprado = listaCatalogo.get(position)
            listaCarrinho.add(produtoComprado)

            arrayAdapterCarrinho =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCarrinho)
            binding.listViewCarrinho.adapter = arrayAdapterCarrinho

            valorTotalCarrinho += produtoComprado.preco
            pesoTotalCarrinho += produtoComprado.peso

            valorTotalCarrinho = String.format("%.2f", valorTotalCarrinho).toDouble()
            pesoTotalCarrinho = String.format("%.2f", pesoTotalCarrinho).toDouble()

            binding.textValorTotal.text = "$valorTotalCarrinho €"
            binding.textPesoTotal.text = "$pesoTotalCarrinho Kg."


        }

        binding.listViewCarrinho.setOnItemClickListener { parent, view, position, id ->

            mediaPlayerBooo.start()

            var produtoRemovido = listaCarrinho.get(position)
            listaCarrinho.removeAt(position)

            arrayAdapterCarrinho =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, listaCarrinho)
            binding.listViewCarrinho.adapter = arrayAdapterCarrinho

            valorTotalCarrinho -= produtoRemovido.preco
            pesoTotalCarrinho -= produtoRemovido.peso

            valorTotalCarrinho = String.format("%.2f", valorTotalCarrinho).toDouble()
            pesoTotalCarrinho = String.format("%.2f", pesoTotalCarrinho).toDouble()

            binding.textValorTotal.text = "$valorTotalCarrinho €"
            binding.textPesoTotal.text = "$pesoTotalCarrinho Kg."

        }
    }
}