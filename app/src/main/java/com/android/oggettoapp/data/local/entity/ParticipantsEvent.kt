package com.android.oggettoapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "participants_event")
data class ParticipantsEvent(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "event_id")
    val eventId: Int
)
