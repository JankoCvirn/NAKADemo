package com.cvirn.nakademo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cvirn.nakademo.component.NakaTopAppBar
import com.cvirn.nakademo.navigation.AppNavigation
import com.cvirn.nakademo.ui.theme.NAKADemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NAKADemoTheme {
                val navController = rememberNavController()
                Scaffold(topBar = {
                    val currentDestination =
                        navController.currentBackStackEntryAsState().value?.destination?.route
                    NakaTopAppBar(
                        navController, currentDestination
                    )
                },
                    content = { padding ->
                        AppNavigation(padding, navController)
                    })
            }
        }
    }
}
