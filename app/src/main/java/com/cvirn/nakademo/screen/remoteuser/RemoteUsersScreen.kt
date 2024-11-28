package com.cvirn.nakademo.screen.remoteuser

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cvirn.nakademo.viewmodel.RemoteUsersViewModel
import org.koin.androidx.compose.koinViewModel
import com.cvirn.remote.model.User as RemoteUser

@Suppress("ktlint:standard:function-naming")
@Composable
fun RemoteUsersScreen(
    onNavigateToUsersPost: (RemoteUser) -> Unit,
    onNavigateToCreatePost: (RemoteUser) -> Unit,
    paddingValues: PaddingValues,
) {
    val remoteUsersViewModel: RemoteUsersViewModel = koinViewModel()
    val screenState by remoteUsersViewModel.allRemoteUsers.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        remoteUsersViewModel.loadUsers()
    }
    RemoteUsersScreenContent(
        paddingValues = paddingValues,
        screenState = screenState,
        onNavigateToUsersPost = onNavigateToUsersPost,
        onNavigateToCreatePost = onNavigateToCreatePost,
    )
}
