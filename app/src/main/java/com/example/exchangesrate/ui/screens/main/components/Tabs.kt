package com.example.exchangesrate.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.exchangesrate.R
import com.example.exchangesrate.ui.screens.favorites.FavoritesScreen
import com.example.exchangesrate.ui.screens.popular.PopularScreen

@Composable
fun Tabs() {
    val context = LocalContext.current
    var tabIndex by remember { mutableStateOf(0) }

    val favoriteTitle = context.getString(R.string.favorite_screen_title)
    val popularTitle = context.getString(R.string.popular_screen_title)
    val tabTitles = listOf(favoriteTitle, popularTitle)

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize(1f).zIndex(1f)
    ) {
        when (tabIndex) {
            0 -> FavoritesScreen()
            1 -> PopularScreen()
        }
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = Color.Transparent,
            modifier = Modifier.background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFBBBEFF),
                        Color(0xB94D00FF),
                    )
                )
            )
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = tabIndex == index,
                    selectedContentColor = Color(0xFF000000),
                    unselectedContentColor = Color(0xB9F3F3F3),
                    onClick = { tabIndex = index },
                    modifier = Modifier.heightIn(min = 65.dp),
                    text = {
                        Text(
                            text = title,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                        )
                    }
                )
            }
        }
    }
}