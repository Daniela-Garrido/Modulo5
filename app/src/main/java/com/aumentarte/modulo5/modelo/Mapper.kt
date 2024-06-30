package com.aumentarte.modulo5.modelo

import com.aumentarte.modulo5.modelo.local.Entidades.AccountsLocal
import com.aumentarte.modulo5.modelo.local.Entidades.TransaccionLocal
import com.aumentarte.modulo5.modelo.local.Entidades.Usuariolocal
import com.aumentarte.modulo5.modelo.remoto.Internet.AccountsRespuesta
import com.aumentarte.modulo5.modelo.remoto.Internet.UsuarioRespuesta
import com.aumentarte.modulo5.modelo.remoto.Internet.Transactions

fun UsuarioMapper(usuario: UsuarioRespuesta): Usuariolocal {
    return Usuariolocal(
        id = usuario.id,
        first_name = usuario.first_name,
        last_name = usuario.last_name,
        email = usuario.email,
        password = usuario.password,
        points = usuario.points,
        roleId = usuario.roleId,
        createdAt = usuario.createdAt,
        updatedAt = usuario.updateAt
    )
}


fun cuentaInter(cuenta: AccountsRespuesta): AccountsLocal {
    return AccountsLocal(
        id = cuenta.id,
        creationDate = cuenta.creationDate,
        money = cuenta.money,
        isBlocked = cuenta.isBlocked,
        userId = cuenta.userId,
        createdAt = cuenta.createdAt,
        updatedAt = cuenta.updatedAt
    )
}

fun transaccionesInter(transaccion: Transactions): TransaccionLocal {
    return TransaccionLocal(
        id = transaccion.id,
        amount = transaccion.amount,
        concept = transaccion.concept,
        date = transaccion.date ?: "",
        type = transaccion.type,
        accountId = transaccion.accountId,
        userId = transaccion.userId,
        toAccountId = transaccion.toAccountId,
        createdAt = transaccion.createdAt,
        updatedAt = transaccion.updatedAt

    )
}

