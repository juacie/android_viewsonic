package com.juacie.viewsonic.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = lightColorScheme(
    primary = Purple80,
    onPrimary = Color.White,

    secondary = PurpleGrey80,
    onSecondary = Color.White,

    tertiary = Pink80,
    onTertiary = Color.White,

    background = Color.DarkGray,
    onBackground = Color.White,

    surface = Color.DarkGray,
    onSurface = Color.Black,

    error = Color.Red,
    onError = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.White,

    secondary = PurpleGrey40,
    onSecondary = Color.White,

    tertiary = Pink40,
    onTertiary = Color.White,

    background = Color.White,
    onBackground = Color.Black,

    surface = Color.White,
    onSurface = Color.Black,

    error = Color.Red,
    onError = Color.White,
)

@Composable
fun ViewSonicTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}