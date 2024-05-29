package com.aumentarte.modulo5.modelo.remoto.Internet

data class UsuarioInter(
    val id: Long,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Int,
    val points: Int
)