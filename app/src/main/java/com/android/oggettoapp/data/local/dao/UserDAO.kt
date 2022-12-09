package com.android.oggettoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.oggettoapp.data.local.entity.UserEntity

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(userEntity: UserEntity)

    @Query("SELECT * FROM users WHERE login=:login")
    suspend fun authUser(login: String): UserEntity
}