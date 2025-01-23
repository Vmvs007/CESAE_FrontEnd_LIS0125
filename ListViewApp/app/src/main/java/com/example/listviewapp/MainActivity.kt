package com.example.listviewapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var listaNomes = ArrayList<String>()
        listaNomes.add("Vitor")
        listaNomes.add("Ana")
        listaNomes.add("Joaquim")
        listaNomes.add("José")

        var arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaNomes)
        binding.listViewNomes.adapter=arrayAdapter

        binding.buttonAdicionarNome.setOnClickListener {
            var novoNome:String = binding.editNovoNome.text.toString()

            listaNomes.add(novoNome)

            arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaNomes)
            binding.listViewNomes.adapter=arrayAdapter

        }

        binding.listViewNomes.setOnItemClickListener{ parent,view,position,id ->

            // Toast.makeText(this,"Carregou em ${listaNomes.get(position)}",Toast.LENGTH_SHORT).show()

            listaNomes.removeAt(position)

            arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaNomes)
            binding.listViewNomes.adapter=arrayAdapter
        }

    }
}