package com.cvirn.remote.service

import com.cvirn.remote.model.userpost.CreatePostRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.contentType
import io.ktor.utils.io.InternalAPI

class ApiServiceImpl(
    private val client: HttpClient,
) {
    suspend fun getAllUsers() = client.get(USERS_END_POINT)

    suspend fun getAllUserPosts() = client.get(USERS_POSTS_END_POINT)

    @OptIn(InternalAPI::class)
    suspend fun setUserPost(
        userId: Int,
        title: String,
        content: String,
    ) = client.post(
        USERS_POSTS_END_POINT,
    ) {
        contentType(io.ktor.http.ContentType.Application.Json)
        setBody(
            CreatePostRequest(title = title, body = content, userId = userId),
        )
    }

    companion object {
        private const val USERS_END_POINT =
            "https://jsonplaceholder.typicode.com/users"
        private const val USERS_POSTS_END_POINT =
            "https://jsonplaceholder.typicode.com/posts"
    }
}
