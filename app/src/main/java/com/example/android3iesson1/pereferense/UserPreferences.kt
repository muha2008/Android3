package com.example.android3iesson1.pereferense

import android.content.Context
import com.example.android3iesson1.models.User

class UserPreferences(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun isRegistered(): Boolean {
        return sharedPreferences.contains("username") &&
                sharedPreferences.contains("age") &&
                sharedPreferences.contains("email") &&
                sharedPreferences.contains("password")
    }

    fun saveUser(user: User) {
        with(sharedPreferences.edit()) {
            putString("username", user.username)
            putInt("age", user.age)
            putString("email", user.email)
            putString("password", user.password)
            apply()
        }
    }

    fun getUser(): User? {
        val username = sharedPreferences.getString("username", null)
        val age = sharedPreferences.getInt("age", -1)
        val email = sharedPreferences.getString("email", null)
        val password = sharedPreferences.getString("password", null)

        return if (username != null && age != -1 && email != null && password != null) {
            User(username, age, email, password)
        } else {
            null
        }
    }

    fun clear() {
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
    }
}