package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.nakademo.screen.posts.UserPostsScreenState
import com.cvirn.nakademo.usecase.RemoteUserUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserPostsViewModel(
    private val remoteUserUseCaseImpl: RemoteUserUseCaseImpl,
) : ViewModel() {
    private val _allUserPosts =
        MutableStateFlow(
            UserPostsScreenState(
                postList = emptyList(),
                isSuccess = true,
            ),
        )
    val allUserPosts: StateFlow<UserPostsScreenState> = _allUserPosts

    fun loadUserPosts(userId: Int) {
        viewModelScope.launch {
            val result = remoteUserUseCaseImpl.getAllPostsForUser(userId = userId)
            _allUserPosts.value = result
        }
    }

    fun createPost(
        title: String,
        content: String,
        userId: Int,
    ) {
        viewModelScope.launch {
            val result =
                remoteUserUseCaseImpl.setUserPost(
                    userId = userId,
                    title = title,
                    content = content,
                )
            _allUserPosts.value =
                _allUserPosts.value.copy(
                    isCreatePostSuccess = result,
                    showCreatePostSnackBar = true,
                )
        }
    }
}
