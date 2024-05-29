package com.aumentarte.modulo5.modelo.local.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_cuenta")
data class AccountsLocal(
    @PrimaryKey
    val id: Long,
    val creationDate: String,
    val money: String,
    val isBlocked: Boolean,
    val userId: Long,
    val createdAt: String,
    val updatedAt: String
)
