package com.android.oggettoapp.fragments.createEvent

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.oggettoapp.R
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.databinding.FragmentCreateEventBinding
import com.android.oggettoapp.fragments.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.createEventButton.setOnClickListener {
            viewModel.createEvent(EventEntity(
                id = 0,
                title = binding.titleEditText.text.toString(),
                description = binding.descriptionEditText.text.toString(),
                telegram = binding.telegramEditText.text.toString(),
                date = binding.dateEditText.text.toString(),
                createDate = SimpleDateFormat("dd.MM.yy", Locale.getDefault()).format(Date())
            ))

            findNavController().navigate(R.id.action_createEventFragment_to_homeFragment)
        }
    }
}