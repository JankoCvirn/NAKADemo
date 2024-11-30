package com.cvirn.nakademo.screen.posts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.cvirn.nakademo.viewmodel.UserPostsViewModel
import org.koin.androidx.compose.koinViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserPostsScreen(userId: Int) {
    val userPostsViewModel: UserPostsViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        userPostsViewModel.loadUserPosts(userId = userId)
    }
    UserPostsScreenContent(
        userId = userId,
        userPostViewModel = userPostsViewModel,
    )
}
