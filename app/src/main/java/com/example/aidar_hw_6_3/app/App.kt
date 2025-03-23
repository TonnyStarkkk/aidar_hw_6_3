package com.example.aidar_hw_6_3.app

import android.app.Application
import com.example.aidar_hw_6_3.data.serviceLocator.dataModule
import com.example.aidar_hw_6_3.ui.serviceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, uiModule)
        }
    }
}