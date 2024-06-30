package com.aumentarte.modulo5.modelo.remoto.Internet

data class UsuarioRespuesta(
    val id: Long,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Int,
    val points: Int,
    val createdAt: String,
    val updateAt: String
)