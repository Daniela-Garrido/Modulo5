package com.aumentarte.modulo5.modelo

import androidx.lifecycle.LiveData
import com.aumentarte.modulo5.modelo.local.Entidades.TransaccionLocal
import com.aumentarte.modulo5.modelo.local.WalletDao
import com.aumentarte.modulo5.modelo.remoto.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repositorio(private val walletDao: WalletDao, private val api: Api) {

    suspend fun fetchUser(token: String) {
        withContext(Dispatchers.IO) {
            val response = api.infoUser(token).execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    val usuarioLocal = UsuarioMapper(it)
                    walletDao.insertUsuario(usuarioLocal)
                }
            }
        }
    }

    fun getAccountId(userId: Long): LiveData<List<TransaccionLocal>> {
        return walletDao.getTransaccionId(userId)
    }

    suspend fun fetchSaveAccounts(token: String) {
        withContext(Dispatchers.IO) {
            val response = api.infoAccounts(token).execute()
            if (response.isSuccessful) {
                response.body()?.forEach {
                    val accountLocal = cuentaInter(it)
                    walletDao.insertAccounts(accountLocal)
                }
            }
        }
    }

    suspend fun fetchTransaccion(token: String) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.infoTransactions(token).execute()
                if (response.isSuccessful) {
                    val transactionResponse = response.body()
                    if (transactionResponse != null) {
                        transactionResponse.data.forEach { transaction ->
                            val transactionLocal = transaccionesInter(transaction)
                            walletDao.insertTransaccion(transactionLocal)
                        }
                    }
                }
            }catch (e: Exception){

            }
        }
    }
}





