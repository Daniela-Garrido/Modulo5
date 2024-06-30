package com.aumentarte.modulo5.modelo.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aumentarte.modulo5.modelo.local.Entidades.AccountsLocal
import com.aumentarte.modulo5.modelo.local.Entidades.TransaccionLocal
import com.aumentarte.modulo5.modelo.local.Entidades.Usuariolocal

@Dao
interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsuario(usuario: Usuariolocal)

    @Query("SELECT * FROM tabla_usuario WHERE id= :id")
    fun getUsuarios(id: Long): LiveData<Usuariolocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccounts(cuenta: AccountsLocal)

    @Query("SELECT * FROM tabla_cuenta WHERE id= :id")
    fun getCuentas(id: Long): LiveData<AccountsLocal>

    @Query("SELECT * FROM tabla_transaccion WHERE id= :id")
    fun getTransacciones(id: Long): LiveData<TransaccionLocal>

    @Query("SELECT * FROM tabla_cuenta WHERE userId= :userId")
    fun getAccountsId(userId: Long): LiveData<List<AccountsLocal>>

    @Query("SELECT * FROM tabla_transaccion WHERE userId= :userId")
    fun getTransaccionId(userId: Long): LiveData<List<TransaccionLocal>>


}