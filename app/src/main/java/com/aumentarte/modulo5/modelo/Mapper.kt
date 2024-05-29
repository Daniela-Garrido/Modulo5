package com.aumentarte.modulo5.modelo

import com.aumentarte.modulo5.modelo.local.Entidades.Usuariolocal
import com.aumentarte.modulo5.modelo.remoto.Internet.UsuarioInter

fun UsuarioMapper(usuario: UsuarioInter): Usuariolocal {
    return Usuariolocal(
        id = usuario.id,
        first_name = usuario.first_name,
        last_name = usuario.last_name,
        email = usuario.email,
        password = usuario.password,
        roleId = usuario.roleId,

    )
}