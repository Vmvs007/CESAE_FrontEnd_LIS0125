package com.example.onlinestoreapp

class Produto(val categoria: String, val nome: String, val preco: Double, val peso: Double) {

    override fun toString(): String {
        return "$categoria\t|\t$nome\t|\t$preco €"
    }
}