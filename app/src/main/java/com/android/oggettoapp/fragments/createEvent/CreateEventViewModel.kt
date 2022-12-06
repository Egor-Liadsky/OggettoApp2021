package com.android.oggettoapp.fragments.createEvent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(private val repository: EventRepository): ViewModel(){

    fun createEvent(event: EventEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.createEvent(event)
        Log.e("ROOM DATABASE", event.toString())
    }
}