package com.aumentarte.modulo5.modelo.remoto.Internet

import com.google.gson.annotations.SerializedName

data class TransaccionRequest(
    val amount: Long,
    val concept: String,
    val type: String,
    val accountId: Long,
    val userId: Long,
    @SerializedName("to_account_id")
    val toAccountId: Long
)
