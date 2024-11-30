package com.cvirn.nakademo.screen.remoteuser

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cvirn.nakademo.viewmodel.RemoteUsersViewModel
import org.koin.androidx.compose.koinViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun RemoteUsersScreen(
    onNavigateToUsersPost: (Int?) -> Unit,
    paddingValues: PaddingValues,
) {
    val remoteUsersViewModel: RemoteUsersViewModel = koinViewModel()
    val screenState by remoteUsersViewModel.allRemoteUsers.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        remoteUsersViewModel.loadRemoteUsers()
    }
    RemoteUsersScreenContent(
        paddingValues = paddingValues,
        screenState = screenState,
        onNavigateToUsersPost = onNavigateToUsersPost,
    )
}
