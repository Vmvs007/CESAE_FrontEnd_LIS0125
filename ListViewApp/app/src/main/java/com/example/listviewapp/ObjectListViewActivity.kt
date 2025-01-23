package com.example.listviewapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewapp.databinding.ActivityObjectListViewBinding

class ObjectListViewActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityObjectListViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var admin = Utilizador("admin", "password123")
        var staff1 = Utilizador("vitor", "vitor123")
        var staff2 = Utilizador("staff", "root")

        var listaUtilizadores = ArrayList<Utilizador>()
        listaUtilizadores.add(admin)
        listaUtilizadores.add(staff1)
        listaUtilizadores.add(staff2)

        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)
        binding.listViewUtilizadores.adapter = arrayAdapter

        binding.listViewUtilizadores.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this,listaUtilizadores.get(position).password,Toast.LENGTH_SHORT).show()

        }


    }
}