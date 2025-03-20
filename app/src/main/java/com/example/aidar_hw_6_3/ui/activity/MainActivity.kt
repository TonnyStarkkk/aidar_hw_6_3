package com.example.aidar_hw_6_3.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.aidar_hw_6_3.ui.screens.main.MainScreen
import com.example.aidar_hw_6_3.ui.theme.Aidar_hw_6_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aidar_hw_6_3Theme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}