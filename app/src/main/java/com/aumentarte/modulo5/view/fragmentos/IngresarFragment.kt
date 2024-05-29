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
import com.aumentarte.modulo5.databinding.FragmentHomeBinding
import com.aumentarte.modulo5.databinding.FragmentIngresarBinding

class IngresarFragment : Fragment() {

    private lateinit var binding: FragmentIngresarBinding

    companion object {
        fun newInstance() = IngresarFragment()
    }

    private val viewModel: IngresarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIngresarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            binding.ingremail.setText(user.nombre)
            binding.ingrecontras.setText(user.apellido)
        })

        viewModel.isValid.observe(viewLifecycleOwner, Observer { isValid ->
            if (!isValid) {

                Toast.makeText(requireContext(), "Ingrese Datos Válidos", Toast.LENGTH_SHORT).show()
            }

            binding.btnhome.setOnClickListener{
                val email = binding.ingremail.text.toString()
                val clave = binding.ingrecontras.text.toString()

                viewModel.updateUser(email, clave)

            }
            if (viewModel.isValid.value == true) {
                findNavController().navigate(R.id.action_ingresarFragment_to_homeFragment)
            }

        })

    }
}