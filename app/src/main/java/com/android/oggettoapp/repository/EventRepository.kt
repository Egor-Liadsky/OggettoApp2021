package com.android.oggettoapp.repository

import com.android.oggettoapp.data.local.dao.EventDAO
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.data.local.entity.ParticipantsEvent
import javax.inject.Inject

class EventRepository @Inject constructor(private val eventDAO: EventDAO) {

    suspend fun createEvent(event: EventEntity) = eventDAO.createEvent(event)

    suspend fun getAllEvents(): List<EventEntity> = eventDAO.getAllEvents()

    suspend fun deleteEventById(id: Int) = eventDAO.deleteEventById(id)

    suspend fun participantEvent(participantEvent: ParticipantsEvent) = eventDAO.participantEvent(participantEvent)
}