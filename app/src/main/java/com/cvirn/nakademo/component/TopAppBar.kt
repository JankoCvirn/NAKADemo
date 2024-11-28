package com.cvirn.nakademo.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cvirn.nakademo.R
import com.cvirn.nakademo.navigation.NavigationRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NakaTopAppBar(
    navController: NavHostController,
    currentDestination: String?,
) {
    TopAppBar(
        modifier = Modifier.padding(bottom = 32.dp),
        title = { Text(stringResource(R.string.app_name)) },
        navigationIcon = {
            if (currentDestination != NavigationRoute.HOME_SCREEN) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.action_back),
                    )
                }
            } else {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = stringResource(R.string.action_home),
                    )
                }
            }
        },
        actions = {
            if (currentDestination != NavigationRoute.STATISTICS_SCREEN) {
                IconButton(onClick = { navController.navigate(NavigationRoute.STATISTICS_SCREEN) }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.List,
                        contentDescription = stringResource(R.string.action_back),
                    )
                }
            }
        },
    )
}
