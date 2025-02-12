package com.juacie.viewsonic

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.juacie.viewsonic.core.BaseActivity
import com.juacie.viewsonic.ui.navagation.BottomNavigation
import com.juacie.viewsonic.ui.screen.setting.SettingPage
import com.juacie.viewsonic.ui.screen.time.TimePage

class MainActivity : BaseActivity() {

    @Composable
    override fun ScreenContent() {
        val items = listOf(
            BottomNavigation.Time,
            BottomNavigation.Setting,
        )
        var selectedTab by remember { mutableIntStateOf(BottomNavigation.Time.screenRoute) }
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
                BottomNavigation.Time.screenRoute -> TimePage(
                    modifier = Modifier.padding(
                        paddingValues
                    )
                )

                BottomNavigation.Setting.screenRoute -> SettingPage(
                    modifier = Modifier.padding(
                        paddingValues
                    )
                )
            }
        }
    }
}