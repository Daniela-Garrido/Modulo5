package com.aumentarte.modulo5.modelo.local

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aumentarte.modulo5.modelo.local.Entidades.Usuariolocal

interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsuario(usuario: Usuariolocal)


    @Query("SELECT * FROM tabla_usuario WHERE id= :id")
    fun getUsuarios(id: Long): LiveData<Usuariolocal>







}