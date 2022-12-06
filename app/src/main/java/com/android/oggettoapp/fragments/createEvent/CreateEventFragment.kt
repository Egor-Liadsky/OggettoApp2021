package com.android.oggettoapp.fragments.createEvent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.oggettoapp.R
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.databinding.FragmentCreateEventBinding
import com.android.oggettoapp.fragments.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateEventFragment : Fragment() {

    private val viewModel: CreateEventViewModel by viewModels()
    private lateinit var binding: FragmentCreateEventBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateEventBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.createEventButton.setOnClickListener {
            viewModel.createEvent(EventEntity(
                id = 0,
                title = binding.titleEditText.text.toString(),
                description = binding.descriptionEditText.text.toString(),
                telegram = binding.telegramEditText.text.toString(),
                date = binding.dateEditText.text.toString(),
                createDate = "04.12.2022"
            ))

            findNavController().navigate(R.id.action_createEventFragment_to_homeFragment)
        }
    }
}