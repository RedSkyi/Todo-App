package fr.antoinev.todoapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = lightColors(
    background = VeryDarkGrayishBlue,
    primary = LightGrayishBlue,
    primaryVariant = DarkGrayishBlue,
    secondary = VividRed
)

@Composable
fun TodoAppTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}