package com.cvirn.nakademo.screen.posts

import com.cvirn.remote.model.userpost.AllPostsItem

data class UserPostsScreenState(
    val postList: List<AllPostsItem>,
    val isSuccess: Boolean,
    val error: String? = null,
    val showCreatePostSnackBar: Boolean? = null,
    val isCreatePostSuccess: Boolean? = false,
)
