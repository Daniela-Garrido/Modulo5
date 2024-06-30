package com.aumentarte.modulo5.modelo.remoto.Internet

data class UserRequest(
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Int
)
