package com.example.android3iesson1.ui.activity

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.android3iesson1.R
import com.example.android3iesson1.databinding.ActivityMainBinding
import com.example.android3iesson1.pereferense.UserPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userPreferences = UserPreferences(this)
        val navController = findNavController(R.id.fragment_container)

        if (!userPreferences.isRegistered()) {

            navController.navigate(R.id.signFragment)
        } else {

            navController.navigate(R.id.homeFragment)
        }
    }
}