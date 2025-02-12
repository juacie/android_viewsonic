package com.juacie.viewsonic.ui.navagation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.juacie.viewsonic.R

sealed class BottomNavigation(val screenRoute: Int, val titleRes: Int, val icon: ImageVector) {
    data object Time : BottomNavigation(0, R.string.text_times, Icons.Filled.Menu)
    data object Setting : BottomNavigation(1, R.string.text_setting, Icons.Filled.Settings)
}