package com.juacie.viewsonic.app.main.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.juacie.viewsonic.R
import com.juacie.viewsonic.app.main.viewModel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val items = listOf(
        BottomNavItem.Time,
        BottomNavItem.Setting,
    )
    var selectedTab by remember { mutableIntStateOf(BottomNavItem.Time.screenRoute) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        label = { Text(text = stringResource(id = item.titleRes)) },
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = stringResource(id = item.titleRes)
                            )
                        },
                        selected = selectedTab == item.screenRoute,
                        onClick = { selectedTab = item.screenRoute }
                    )
                }
            }
        }
    ) { paddingValues ->
        when (selectedTab) {
            BottomNavItem.Time.screenRoute -> TimePage(modifier = Modifier.padding(paddingValues))
            BottomNavItem.Setting.screenRoute -> SettingPage(
                modifier = Modifier.padding(
                    paddingValues
                )
            )
        }
    }
}

sealed class BottomNavItem(val screenRoute: Int, val titleRes: Int, val icon: ImageVector) {
    data object Time : BottomNavItem(0, R.string.text_times, Icons.Filled.Menu)
    data object Setting : BottomNavItem(1, R.string.text_setting, Icons.Filled.Settings)
}

@Composable
fun TimePage(modifier: Modifier = Modifier) {
    // Time page content
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Times", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun SettingPage(modifier: Modifier = Modifier) {
    // Settings page content
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Setting", style = MaterialTheme.typography.headlineLarge)
    }
}
