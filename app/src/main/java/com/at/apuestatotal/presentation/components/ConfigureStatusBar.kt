import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun ToggleStatusBar(isVisible: Boolean) {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    SideEffect {
        val windowInsetsController = activity?.window?.let {
            WindowCompat.getInsetsController(it, it.decorView)
        }
        if (isVisible) {
            windowInsetsController?.show(WindowInsetsCompat.Type.statusBars())
        } else {
            windowInsetsController?.hide(WindowInsetsCompat.Type.statusBars())
        }
    }
}


@Composable
fun SetStatusBarIconsColor(isLightIcons: Boolean) {
    val context = LocalContext.current
    val activity = context as? ComponentActivity

    SideEffect {
        activity?.window?.let { window ->
            val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.isAppearanceLightStatusBars = isLightIcons
        }
    }
}