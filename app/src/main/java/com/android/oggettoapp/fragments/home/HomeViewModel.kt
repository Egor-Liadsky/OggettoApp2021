package com.android.oggettoapp.fragments.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.data.local.entity.ParticipantsEvent
import com.android.oggettoapp.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: EventRepository) : ViewModel() {

    private val _events = MutableLiveData<List<EventEntity>>()
    val events: LiveData<List<EventEntity>> = _events

    fun createEvent(event: EventEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.createEvent(event)
        Log.e("ROOM DATABASE", event.toString())
    }

    fun getAllEvents() = viewModelScope.launch(Dispatchers.IO) {
        Log.e("TESTTEST", repository.getAllEvents().toString())
        _events.postValue(repository.getAllEvents())
    }

    fun deleteFolderById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteEventById(id)
    }

    fun participantEvent(event: ParticipantsEvent) = viewModelScope.launch(Dispatchers.IO) {
        repository.participantEvent(event)
        Log.e("PARTICIPANT", event.toString())
    }
}