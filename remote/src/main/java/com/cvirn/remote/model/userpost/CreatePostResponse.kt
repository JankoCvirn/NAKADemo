package com.cvirn.remote.model.userpost

data class CreatePostResponse(
    val createPost: CreatePost?,
    val isSuccess: Boolean,
    val errorMessage: String? = "",
)
