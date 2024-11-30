package com.cvirn.remote.model.userpost

data class AllPostsResponse(
    val postsList: List<AllPostsItem>,
    val isSuccess: Boolean,
    val errorMessage: String? = "",
)
