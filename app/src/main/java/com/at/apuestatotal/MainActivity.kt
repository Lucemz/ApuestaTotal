package com.at.apuestatotal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        setContent {
            ApuestaTotalTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    navHostController = rememberNavController()

                    AppNavigation(
                        navHostController = navHostController,
                        innerPadding = innerPadding,
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