package com.example.onlinestoreapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.onlinestoreapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mediaPlayerCorrect = MediaPlayer.create(applicationContext,R.raw.correct)
        val mediaPlayerWrong = MediaPlayer.create(applicationContext,R.raw.wrong)


        val listaLoginsValidos = ArrayList<Utilizador>()
        listaLoginsValidos.add(Utilizador("admin", "123"))
        listaLoginsValidos.add(Utilizador("root", "999"))
        listaLoginsValidos.add(Utilizador("vitor", "vitor123"))
        listaLoginsValidos.add(Utilizador("staff", "p4ss"))
        listaLoginsValidos.add(Utilizador("online", "store"))

        val sharedPreferences = this.getSharedPreferences("username", Context.MODE_PRIVATE)
        val usernamePredefinido = sharedPreferences.getString("username","")

        binding.editUsername.setText(usernamePredefinido)



        binding.buttonLogin.setOnClickListener {

            // Captar os dados introduzidos
            var usernameInserido: String = binding.editUsername.text.toString()
            var passwordInserida: String = binding.editPassword.text.toString()

            // Declarar variável de controlo (flag)
            var credenciaisValidas : Boolean = false

            // Iterar a lista dos logins válidos
            for(utilizadorAtual:Utilizador in listaLoginsValidos){

                if(usernameInserido.equals(utilizadorAtual.username) && passwordInserida.equals(utilizadorAtual.password)){
                    credenciaisValidas=true
                }

            }

            if(credenciaisValidas){

                mediaPlayerCorrect.start()

                // Atualizar o sharedPreferences
                val editor: SharedPreferences.Editor=sharedPreferences.edit()
                editor.putString("username",usernameInserido)
                editor.apply()

                // Redirecionar para a Activity da Loja Online
                val i = Intent(this,MainActivity::class.java)
                startActivity(i)

            }else{

                mediaPlayerWrong.start()

                // Apresentar um Toast
                Toast.makeText(applicationContext, "Login Inválido", Toast.LENGTH_SHORT).show()

                // Limpamos os campos
                binding.editUsername.setText("")
                binding.editPassword.setText("")
            }


        }


    }
}