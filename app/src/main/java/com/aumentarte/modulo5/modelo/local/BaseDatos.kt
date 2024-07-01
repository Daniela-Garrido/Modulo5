package com.aumentarte.modulo5.modelo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aumentarte.modulo5.modelo.local.Entidades.AccountsLocal
import com.aumentarte.modulo5.modelo.local.Entidades.TransaccionLocal
import com.aumentarte.modulo5.modelo.local.Entidades.Usuariolocal

@Database(
    entities = [Usuariolocal::class, TransaccionLocal::class, AccountsLocal::class], version = 1, exportSchema = true)

abstract class BaseDatos : RoomDatabase() {

    abstract fun getWalletDao(): WalletDao

    companion object {

        @Volatile
        private var INSTANCE: BaseDatos? = null

        fun getDataBase(context: Context): BaseDatos? {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "bd_wallet"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}


