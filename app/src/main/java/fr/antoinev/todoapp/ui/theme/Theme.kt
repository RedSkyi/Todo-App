package fr.antoinev.todoapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = VeryDarkGrayishBlue,
    primary = LightGrayishBlue,
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