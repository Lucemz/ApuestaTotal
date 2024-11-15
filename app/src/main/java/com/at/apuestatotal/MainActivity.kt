package com.at.apuestatotal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.at.apuestatotal.presentation.navigation.AppNavRoute
import com.at.apuestatotal.presentation.navigation.AppNavigation
import com.at.apuestatotal.presentation.ui.theme.ApuestaTotalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
       // windowInsetsController?.hide(WindowInsetsCompat.Type.statusBars())
        windowInsetsController?.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        setContent {
            ApuestaTotalTheme {

                Surface(
                    modifier = Modifier.fillMaxSize().animateContentSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    navHostController = rememberNavController()

                    AppNavigation(
                        navHostController = navHostController,
                        startDestination = AppNavRoute.MainMenuNR.route
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApuestaTotalTheme {
        Greeting("Android")
    }
}