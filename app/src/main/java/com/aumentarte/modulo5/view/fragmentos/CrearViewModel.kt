package com.aumentarte.modulo5.view.fragmentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aumentarte.modulo5.modelo.remoto.Internet.UsuarioInter

class CrearViewModel : ViewModel() {

    private val _user = MutableLiveData<UsuarioInter>()
    val user: LiveData<UsuarioInter> get() = _user

    private val _isValid = MutableLiveData<Boolean>()
    val isValid: LiveData<Boolean> get() = _isValid

    //para actualizar
    fun updateUser(first_name: String, last_name: String, email: String?,password: String?) {
        val newUser = UsuarioInter(first_name, last_name, email,password)
        _user.value = newUser
        validateUser(newUser)
    }

    // Método para validar el usuario
    private fun validateUser(user: UsuarioInter) {
        val isNombreValid = user.first_name.isNotBlank()
        val isApellidoValid = user.last_name.isNotBlank()
        val isEmailValid =
            user.email?.let { android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: true
        val isClaveValid = user.password?.let { it.length >= 6 } ?: true

        _isValid.value = isNombreValid && isApellidoValid && isEmailValid && isClaveValid
    }
}
