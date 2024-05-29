package com.aumentarte.modulo5.view.fragmentos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aumentarte.modulo5.modelo.remoto.Internet.UsuarioInter

class IngresarViewModel : ViewModel() {

    private val _user = MutableLiveData<UsuarioInter>()
    val user: LiveData<UsuarioInter> get() = _user

    private val _isValid = MutableLiveData<Boolean>()
    val isValid: LiveData<Boolean> get() = _isValid

    fun updateUser(email: String?, clave: String?) {
        val newUser = UsuarioInter(first_name = null.toString(), last_name = null.toString(), email = email, password = clave)
        _user.value = newUser
        validateUser(newUser)
    }

    private fun validateUser(user: UsuarioInter) {

        val isEmailValid =
            user.email?.let { android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: true
        val isClaveValid = user.password?.let { it.length >= 6 } ?: true

        _isValid.value = isEmailValid && isClaveValid
    }
}