package com.aumentarte.modulo5.modelo.remoto.Internet

data class AccountsRespuesta(
    val id: Long,
    val creationDate: String,
    val money: String,
    val isBlocked: Boolean,
    val userId: Long,
    val createdAt: String,
    val updatedAt: String
)
