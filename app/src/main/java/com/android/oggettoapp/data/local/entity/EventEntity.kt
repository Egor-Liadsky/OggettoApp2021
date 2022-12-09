package com.android.oggettoapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "telegram")
    val telegram: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "createDate")
    val createDate: String
)