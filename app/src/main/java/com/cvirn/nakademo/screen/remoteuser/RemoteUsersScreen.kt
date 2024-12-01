package com.cvirn.nakademo.screen.remoteuser

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cvirn.nakademo.viewmodel.AppViewModel
import com.cvirn.nakademo.viewmodel.RemoteUsersViewModel
import org.koin.androidx.compose.koinViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun RemoteUsersScreen(onNavigateToUsersPost: (Int?) -> Unit) {
    val remoteUsersViewModel: RemoteUsersViewModel = koinViewModel()
    val appViewModel: AppViewModel = koinViewModel()
    val screenState by remoteUsersViewModel.allRemoteUsers.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        remoteUsersViewModel.loadRemoteUsers()
    }
    LaunchedEffect(screenState.error) {
        screenState.error?.let { errorMessage ->
            if (!screenState.isSuccess && errorMessage.isNotEmpty()) {
                appViewModel.showSnackBarMessage()
            }
        }
    }
    RemoteUsersScreenContent(
        screenState = screenState,
        onNavigateToUsersPost = onNavigateToUsersPost,
    )
}
