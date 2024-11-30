package com.cvirn.remote.repository

import com.cvirn.remote.model.user.AllUsersResponse
import com.cvirn.remote.model.userpost.AllPostsResponse
import com.cvirn.remote.model.userpost.CreatePostResponse

interface RemoteRepository {
    suspend fun getAllUsers(): AllUsersResponse

    suspend fun getAllPosts(): AllPostsResponse

    suspend fun setUserPost(
        userId: Int,
        title: String,
        content: String,
    ): CreatePostResponse
}
