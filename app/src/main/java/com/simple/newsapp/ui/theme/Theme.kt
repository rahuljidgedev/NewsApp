package com.simple.newsapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2196F3), // Primary color (blue)
    secondary = Color(0xFFF44336), // Secondary color (red)
    background = Color(0xFF121212), // Background color (dark gray)
    surface = Color(0xFF212121), // Surface color (slightly lighter dark gray)
    onPrimary = Color(0xFFFFFFFF), // Text color on primary color
    onSecondary = Color(0xFFFFFFFF), // Text color on secondary color
    onBackground = Color(0xFFFFFFFF), // Text color on background color
    onSurface = Color(0xFFFFFFFF), // Text color on surface color
    error = Color(0xFFFF0080), // Error color (red)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF03A9F4), // Primary color (light blue)
    secondary = Color(0xFFE91E63), // Secondary color (orange)
    background = Color(0xFFFFFFFF), // Background color (white)
    surface = Color(0xFFF7F7F7), // Surface color (slightly lighter white)
    onPrimary = Color(0xFF000000), // Text color on primary color
    onSecondary = Color(0xFF000000), // Text color on secondary color
    onBackground = Color(0xFF000000), // Text color on background color
    onSurface = Color(0xFF000000), // Text color on surface color
    error = Color(0xFFFF0080), // Error color (red)
)

@Composable
fun NewsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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
    val view = LocalView.current
    if (!view.isInEditMode) {
      SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
      }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}