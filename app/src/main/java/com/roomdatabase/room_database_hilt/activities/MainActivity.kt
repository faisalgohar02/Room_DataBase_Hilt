package com.roomdatabase.room_database_hilt.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roomdatabase.room_database_hilt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.insertBtn.setOnClickListener {
            startActivity(Intent(this,InsertDataActivity::class.java))
        }
        binding.readBtn.setOnClickListener {
            startActivity(Intent(this,ReadAllDataActivity::class.java))
        }
    }
}