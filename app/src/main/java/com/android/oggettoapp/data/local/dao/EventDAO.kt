package com.android.oggettoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.oggettoapp.data.local.entity.EventEntity

@Dao
interface EventDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createEvent(events: EventEntity)

    @Query("SELECT * FROM events")
    suspend fun getAllEvents(): List<EventEntity>

    @Query("DELETE FROM events WHERE id=:id")
    suspend fun deleteEventById(id: Int)
}