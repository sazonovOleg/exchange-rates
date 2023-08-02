package com.example.exchangesrate.ui.screens.splash

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangesrate.infrastructure.repo.DataBaseRepo
import com.example.exchangesrate.ui.screens.main.MainActivity
import kotlinx.coroutines.launch

class SplashActivityVM(application: Application) : AndroidViewModel(application) {
    private fun startMainActivity(context: Context) {
        val mIntent = Intent(context, MainActivity::class.java)
        mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(mIntent)
    }

    private fun initProviderService() {

    }

    private fun initDataBase() {
        viewModelScope.launch {

        }
    }

    init {
        startMainActivity(getApplication())
        initProviderService()
        initDataBase()
    }
}