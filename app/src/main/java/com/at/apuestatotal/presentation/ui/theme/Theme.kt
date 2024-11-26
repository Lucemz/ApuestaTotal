package com.at.apuestatotal.presentation.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.ui.theme.Grays
import com.example.ui.theme.Primary
import com.example.ui.theme.Secondary

private val DarkColorScheme = darkColorScheme(
    primary = Color.Red,
    secondary = Color.White,
    tertiary = Color.Gray)

private val LightColorScheme = lightColorScheme(
  //  primary = Purple40,
  //  secondary = PurpleGrey40,
  //  tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */

)
/*private val ApuestaTotalScheme = lightColorScheme(
    primary = FlexPrimary500,
    secondary = FlexPrimarySkyBlue,
    tertiary = FLexPrimary200,
    onPrimary = Color.Black,
    surface = Color.White,
    background = Color.White
)*/
val ApuestaTotalScheme = lightColorScheme(
    primary = Primary.Red,                  // Rojo primario
    onPrimary = Primary.White,              // Texto sobre el primario en blanco
    primaryContainer = Grays.Gray4,         // Fondo alternativo para primario

    secondary = Secondary.Blue,             // Azul para elementos secundarios
    onSecondary = Primary.White,            // Texto sobre el color secundario en blanco
    secondaryContainer = Grays.Gray3,       // Fondo alternativo para el secundario

    tertiary = Secondary.Yellow,            // Amarillo para elementos terciarios
    onTertiary = Primary.Black,             // Texto sobre el terciario en negro
    tertiaryContainer = Grays.Gray2,        // Fondo alternativo para el terciario

    surface = Primary.White,                // Superficies en blanco
    onSurface = Primary.Black,              // Texto sobre las superficies en negro

    background = Primary.White,             // Fondo en blanco
    onBackground = Primary.Black,           // Texto sobre el fondo en negro

    error = Secondary.RedSecondary,         // Color de error en rojo secundario
    onError = Primary.White,                // Texto sobre el error en blanco
    errorContainer = Grays.Gray             // Fondo alternativo para errores
)

@Composable
fun ApuestaTotalTheme(
    //darkTheme: Boolean = isSystemInDarkTheme(),
    darkTheme: Boolean = false,
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
        else -> ApuestaTotalScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}