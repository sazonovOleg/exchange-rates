package com.example.exchangesrate.ui.screens.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.exchangesrate.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exchangesrate.ui.screens.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        setContent {
            SplashScreen()
        }
    }
}

@Composable
private fun SplashScreen(vm: SplashActivityVM = viewModel()) {
    val context = LocalContext.current

    Surface(
        color = Color.White
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp),
                    contentDescription = "Splash logo"
                )
            }
        }
    }
}