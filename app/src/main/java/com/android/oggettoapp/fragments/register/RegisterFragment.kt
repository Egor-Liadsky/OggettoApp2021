package com.android.oggettoapp.fragments.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.oggettoapp.R
import com.android.oggettoapp.data.local.entity.UserEntity
import com.android.oggettoapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.authButton.setOnClickListener {

            viewModel.registerUser(
                UserEntity(
                    id = 0,
                    login = binding.loginEditText.text.toString(),
                    email = binding.emailEditText.text.toString(),
                    password = binding.passwordEditText.text.toString()
                )
            )

            Toast.makeText(requireContext(), "Вы успешно зарегестрировались", Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }
    }
}