package com.aumentarte.modulo5.view.fragmentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aumentarte.modulo5.model.Usuario

class IngresarViewModel : ViewModel() {

    private val _user = MutableLiveData<Usuario>()
    val user: LiveData<Usuario> get() = _user

    private val _isValid = MutableLiveData<Boolean>()
    val isValid: LiveData<Boolean> get() = _isValid

    fun updateUser(email: String?, clave: String?) {
        val newUser = Usuario(nombre = null.toString(), apellido = null.toString(), email = email, clave = clave)
        _user.value = newUser
        validateUser(newUser)
    }

    private fun validateUser(user: Usuario) {

        val isEmailValid =
            user.email?.let { android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: true
        val isClaveValid = user.clave?.let { it.length >= 6 } ?: true

        _isValid.value = isEmailValid && isClaveValid
    }
}