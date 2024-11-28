package com.cvirn.nakademo.screen.user

import androidx.compose.runtime.Composable
import com.cvirn.nakademo.viewmodel.UserScreenViewModel
import db.User
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserScreen(user: User?, onNavigateBack: () -> Boolean) {
    val userScreenViewModel: UserScreenViewModel = koinViewModel()

    user?.let {
        userScreenViewModel.setUserState(user)
    }
    UserScreenContent(
        userScreenViewModel, onNavigateBack
    )
}
