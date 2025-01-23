package com.example.listatarefasapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.listatarefasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listaAFazer = ArrayList<String>()
        val listaConcluida = ArrayList<String>()


        binding.buttonAdicionarTarefa.setOnClickListener {

            var novaTarefa: String = binding.editNovaTarefa.text.toString()
            listaAFazer.add(novaTarefa)

            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAFazer)
            binding.listViewAFazer.adapter = arrayAdapter

        }


        binding.listViewAFazer.setOnItemClickListener { parent, view, position, id ->

            var tarefaClicada = listaAFazer.get(position)
            listaConcluida.add(tarefaClicada)
            listaAFazer.removeAt(position)

            val arrayAdapterFazer = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAFazer)
            binding.listViewAFazer.adapter = arrayAdapterFazer

            val arrayAdapterConcluida = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaConcluida)
            binding.listViewConcluida.adapter = arrayAdapterConcluida

        }

    }
}