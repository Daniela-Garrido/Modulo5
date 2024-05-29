package com.aumentarte.modulo5.modelo.remoto.Internet

import com.google.gson.annotations.SerializedName

data class TransaccionInter(
    val id: Long,
    val amount: String,
    val concept: String,
    val date: String,
    val type: String,
    val accountId: Long,
    val userId: Long,
    @SerializedName("to_account_id")
    val toAccountId: Long,
)
