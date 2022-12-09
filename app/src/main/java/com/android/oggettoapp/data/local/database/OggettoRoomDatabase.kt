package com.android.oggettoapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.oggettoapp.data.local.dao.EventDAO
import com.android.oggettoapp.data.local.dao.UserDAO
import com.android.oggettoapp.data.local.entity.EventEntity
import com.android.oggettoapp.data.local.entity.ParticipantsEvent
import com.android.oggettoapp.data.local.entity.UserEntity


@Database(
    entities = [UserEntity::class, EventEntity::class, ParticipantsEvent::class],
    version = 6,
    exportSchema = false
)

abstract class OggettoRoomDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDAO

    abstract fun userDao(): UserDAO
}