package com.example.exchangesrate

import android.app.Application
import android.content.Intent
import com.example.exchangesrate.ui.screens.splash.SplashActivity

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startMainActivity()
    }

    private fun startMainActivity() {
        val intent = Intent(baseContext, SplashActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}