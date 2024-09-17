package com.example.sistemaalarmasobrecarga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AlarmDatabase.getDatabase(this)
        val viewModelFactory = AlarmViewModelFactory(db.alarmDao())
        val viewModel = ViewModelProvider(this, viewModelFactory)[AlarmViewModel::class.java]

        setContent {
            DashboardScreen(viewModel)
        }
    }
}
