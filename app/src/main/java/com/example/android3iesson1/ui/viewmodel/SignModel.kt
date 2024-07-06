package com.example.android3iesson1.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android3iesson1.models.User
import com.example.android3iesson1.pereferense.UserPreferences

class SignModel(application: Application) : AndroidViewModel(application) {

    private val userPreferences = UserPreferences(application)
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        userPreferences.getUser()?.let {
            _user.value = it
        }
    }

    fun registerUser(username: String, age: Int, email: String, password: String) {
        val newUser = User(username, age, email, password)
        _user.value = newUser
        userPreferences.saveUser(newUser)
    }

    fun updateUser(username: String, age: Int, email: String, password: String) {
        val updatedUser = User(username, age, email, password)
        _user.value = updatedUser
        userPreferences.saveUser(updatedUser)
    }
}