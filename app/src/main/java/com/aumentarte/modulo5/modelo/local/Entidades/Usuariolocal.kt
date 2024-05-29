package com.aumentarte.modulo5.modelo.local.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_usuario")
data class Usuariolocal(
    @PrimaryKey
    val id: Long,
    val first_name: String,
    val last_name: String,
    val email: String,
    val password: String,
    val roleId: Int,
    val points: Int,
    val createdAt: String,
    val updatedAt: String
)
