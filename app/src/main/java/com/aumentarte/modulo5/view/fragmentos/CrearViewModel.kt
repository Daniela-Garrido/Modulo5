package com.aumentarte.modulo5.view.fragmentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aumentarte.modulo5.model.Usuario

class CrearViewModel : ViewModel() {

    private val _user = MutableLiveData<Usuario>()
    val user: LiveData<Usuario> get() = _user

    private val _isValid = MutableLiveData<Boolean>()
    val isValid: LiveData<Boolean> get() = _isValid

    //para actualizar
    fun updateUser(nombre: String, apellido: String, email: String?, clave: String?) {
        val newUser = Usuario(nombre, apellido, email, clave)
        _user.value = newUser
        validateUser(newUser)
    }

    // Método para validar el usuario
    private fun validateUser(user: Usuario) {
        val isNombreValid = user.nombre.isNotBlank()
        val isApellidoValid = user.apellido.isNotBlank()
        val isEmailValid = user.email?.let { android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: true
        val isClaveValid = user.clave?.let { it.length >= 6 } ?: true

        _isValid.value = isNombreValid && isApellidoValid && isEmailValid && isClaveValid
    }

}