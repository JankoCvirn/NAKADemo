package com.cvirn.nakademo.usecase

import com.cvirn.nakademo.screen.posts.UserPostsScreenState
import com.cvirn.remote.model.user.AllUsersResponse

interface RemoteUser {
    suspend fun getAllRemoteUsers(): AllUsersResponse

    suspend fun getAllPostsForUser(userId: Int): UserPostsScreenState

    suspend fun setUserPost(
        userId: Int,
        title: String,
        content: String,
    ): Boolean
}
