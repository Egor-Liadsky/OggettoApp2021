package com.android.oggettoapp.fragments.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.oggettoapp.data.local.entity.UserEntity
import com.android.oggettoapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<UserEntity>()
    val user: LiveData<UserEntity> = _user

    fun authUser(login: String) = viewModelScope.launch(Dispatchers.IO){
        repository.authUser(login)
        _user.postValue(repository.authUser(login))
        Log.e("REGISTER", repository.authUser(login).toString())
    }

    fun registerUser(userEntity: UserEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.registerUser(userEntity)
        Log.e("REGISTER", userEntity.toString())
    }
}