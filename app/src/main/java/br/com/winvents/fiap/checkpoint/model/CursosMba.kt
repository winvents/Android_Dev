package br.com.winvents.fiap.checkpoint.model

import java.io.Serializable

data class CursosMba(
    val curso: String,
    val campus: String,
    val preco: Double
):Serializable

