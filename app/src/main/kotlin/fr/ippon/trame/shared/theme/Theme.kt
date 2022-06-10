package fr.ippon.trame.shared.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = CyanA700,
    primaryVariant = CyanA700Light,
    secondary = YellowA400,
    surface = Color.Black,
    background = Blue900,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onSurface = Color.White,
    onBackground = Color.White,
)

private val LightColorPalette = lightColors(
    primary = CyanA700,
    primaryVariant = CyanA700Light,
    secondary = YellowA400,
    surface = Color.White,
    background = Grey200,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onSurface = Color.Black,
    onBackground = Color.Black,
)

@Composable
fun TheRickAndMortyEncyclopediaTheme(
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