package com.example.maplesson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maplesson1.databinding.ActivityMyplecesBinding


class MyPlacesActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMyplecesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyplecesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}