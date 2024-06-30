package com.aumentarte.modulo5.modelo.remoto

import com.aumentarte.modulo5.modelo.remoto.Internet.LoginRequest
import com.aumentarte.modulo5.modelo.remoto.Internet.UserRequest
import com.aumentarte.modulo5.modelo.remoto.Internet.UsuarioRespuesta
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @POST("users") //crear usuario
    fun createUser(@Body usuario: UserRequest): Call<UserRequest>

    @POST("auth/login") //iniciar sesión
    fun login(@Body loginRequest: LoginRequest): Call<LoginRequest>

    @GET("auth/me")
    fun infoUser(@Header("Authorization") token: String): Call<UsuarioRespuesta>


}