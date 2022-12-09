package com.android.oggettoapp.repository

import com.android.oggettoapp.data.local.dao.UserDAO
import com.android.oggettoapp.data.local.entity.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDAO: UserDAO){

    suspend fun registerUser(userEntity: UserEntity) = userDAO.registerUser(userEntity)

    suspend fun authUser(login: String): UserEntity = userDAO.authUser(login)
}