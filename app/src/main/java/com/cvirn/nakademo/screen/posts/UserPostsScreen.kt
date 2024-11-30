package com.cvirn.nakademo.screen.posts

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.cvirn.nakademo.viewmodel.UserPostsViewModel
import org.koin.androidx.compose.koinViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserPostsScreen(
    paddingValues: PaddingValues,
    userId: Int,
) {
    val userPostsViewModel: UserPostsViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        userPostsViewModel.loadUserPosts(userId = userId)
    }
    UserPostsScreenContent(
        userId = userId,
        userPostViewModel = userPostsViewModel,
        padding = paddingValues,
    )
}
