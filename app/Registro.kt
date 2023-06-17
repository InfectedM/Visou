package com.example.visou

data class Registro(
    val obra: String,
    val donoObra: String,
    val entidadeExecutante: String,
    val intervenientes: MutableList<Interveniente>
)
