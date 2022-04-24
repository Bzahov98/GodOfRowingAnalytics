package com.bzahov.godofrowing.analytics.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = dark_primary,
    primaryVariant = dark_primaryContainer,
    secondary = dark_secondary,
    onSecondary = dark_onSecondary,
    background = dark_background,
    secondaryVariant = dark_secondaryContainer,
    onError = dark_onError,
    onSurface = dark_onSurface,
    error = dark_error,
    surface = dark_surface,
    onPrimary = dark_onPrimary,
    onBackground = dark_onBackground
)

private val LightColorPalette = lightColors(
    primary = light_primary,
    primaryVariant = light_primaryContainer,
    secondary = light_secondary,
    onSecondary = light_onSecondary,
    background = light_background,
    secondaryVariant = light_secondaryContainer,
    onError = light_onError,
    onSurface = light_onSurface,
    error = light_error,
    surface = light_surface,
    onPrimary = light_onPrimary,
    onBackground = light_onBackground

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun GodOfRowingAnalyticsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}