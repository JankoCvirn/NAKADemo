package com.cvirn.nakademo.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cvirn.nakademo.viewmodel.HomeScreenViewModel
import db.User
import org.koin.androidx.compose.koinViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen(
    onNavigateToCreate: () -> Unit,
    onNavigateToUpdate: (User?) -> Unit,
    paddingValues: PaddingValues,
) {
    val homeScreenViewModel: HomeScreenViewModel = koinViewModel()
    val userList by homeScreenViewModel.allUsersFlow.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        homeScreenViewModel.loadUsers()
    }
    HomeScreenContent(
        padding = paddingValues,
        userList = userList,
        onNavigateToUpdate = onNavigateToUpdate,
        onNavigateToCreate = onNavigateToCreate,
    )
}
