package com.cvirn.nakademo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cvirn.nakademo.component.NakaTopAppBar
import com.cvirn.nakademo.navigation.AppNavigation
import com.cvirn.nakademo.ui.theme.NAKADemoTheme
import com.cvirn.nakademo.viewmodel.AppViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NAKADemoTheme {
                val appViewModel: AppViewModel = koinViewModel()
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }
                val showErrorSnackBar by appViewModel.errorSnackBarFlow.collectAsStateWithLifecycle()
                val errorMessage = stringResource(R.string.general_error)

                LaunchedEffect(showErrorSnackBar) {
                    if (showErrorSnackBar) {
                        snackbarHostState.showSnackbar(
                            message = errorMessage,
                            withDismissAction = true,
                            duration = SnackbarDuration.Short,
                        )
                    }
                }

                Scaffold(
                    topBar = {
                        val currentDestination =
                            navController
                                .currentBackStackEntryAsState()
                                .value
                                ?.destination
                                ?.route
                        NakaTopAppBar(
                            navController,
                            currentDestination,
                        )
                    },
                    snackbarHost = {
                        SnackbarHost(snackbarHostState)
                    },
                    content = { _ ->
                        AppNavigation(navController)
                    },
                )
            }
        }
    }
}
