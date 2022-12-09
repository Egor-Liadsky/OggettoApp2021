package com.android.oggettoapp.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.oggettoapp.R
import com.android.oggettoapp.adapters.event.EventAdapter
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.data.local.entity.ParticipantsEvent
import com.android.oggettoapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val adapter = EventAdapter(
        participateEvent = { participantEvent(it) },
        deleteEvent = { deleteEventById(it) },
    )

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.homeRecyclerView.adapter = adapter

        viewModel.getAllEvents()

        observableData()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.floatingButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createEventFragment)
            Log.e("ROOM DATABASE GET", viewModel.events.value.toString())
        }
    }

    private fun observableData() {
        viewModel.events.observe(viewLifecycleOwner) { list ->
            adapter.setData(list)
        }
    }

    fun deleteEventById(id: Int) {
        lifecycleScope.launch {
            viewModel.deleteFolderById(id)
            delay(100)
            viewModel.getAllEvents()
        }
    }

    fun participantEvent(id: Int) {
        lifecycleScope.launch {
            viewModel.participantEvent(
                ParticipantsEvent(
                    id = 0,
                    login = "Egor",
                    eventId = id
                )
            )
        }
    }
}