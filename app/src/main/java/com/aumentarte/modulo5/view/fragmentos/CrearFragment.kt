package com.aumentarte.modulo5.view.fragmentos

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aumentarte.modulo5.R
import com.aumentarte.modulo5.databinding.FragmentCrearBinding


class CrearFragment : Fragment() {


    private lateinit var binding: FragmentCrearBinding

    companion object {
        fun newInstance() = CrearFragment()
    }

    private val viewModel: CrearViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrearBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observa los cambios en el usuario
        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            binding.ingresenombre.setText(user.nombre)
            binding.ingreseApellido.setText(user.apellido)
            binding.ingresemail.setText(user.email)
            binding.ingrecontra.setText(user.clave)
        })


    }
}
