package com.android.oggettoapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.oggettoapp.data.local.dao.EventDAO
import com.android.oggettoapp.data.local.entity.EventEntity


@Database(entities = [EventEntity::class], version = 4, exportSchema = false)

abstract class OggettoRoomDatabase: RoomDatabase() {

    abstract fun eventDao(): EventDAO
}