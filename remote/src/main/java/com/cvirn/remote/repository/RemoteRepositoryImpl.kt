package com.cvirn.remote.repository

import com.cvirn.remote.model.user.AllUsersResponse
import com.cvirn.remote.model.user.User
import com.cvirn.remote.model.userpost.AllPostsItem
import com.cvirn.remote.model.userpost.AllPostsResponse
import com.cvirn.remote.model.userpost.CreatePostResponse
import com.cvirn.remote.service.ApiServiceImpl
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.http.isSuccess

class RemoteRepositoryImpl(
    private val apiService: ApiServiceImpl,
) : RemoteRepository {
    override suspend fun getAllUsers(): AllUsersResponse =
        try {
            val response = apiService.getAllUsers()
            val list: List<User> = response.body()
            AllUsersResponse(
                usersList = list,
                isSuccess = response.status.isSuccess(),
            )
        } catch (e: ServerResponseException) {
            AllUsersResponse(
                usersList = emptyList(),
                isSuccess = false,
                errorMessage = "${e.response.status}",
            )
        } catch (e: ResponseException) {
            AllUsersResponse(
                usersList = emptyList(),
                isSuccess = false,
                errorMessage = "${e.response.status}",
            )
        } catch (e: Exception) {
            AllUsersResponse(
                usersList = emptyList(),
                isSuccess = false,
                errorMessage = "${e.message}",
            )
        }

    override suspend fun getAllPosts(): AllPostsResponse =
        try {
            val response = apiService.getAllUserPosts()
            val list: List<AllPostsItem> = response.body()
            AllPostsResponse(
                postsList = list,
                isSuccess = response.status.isSuccess(),
            )
        } catch (e: ServerResponseException) {
            AllPostsResponse(
                postsList = emptyList(),
                isSuccess = false,
                errorMessage = "${e.response.status}",
            )
        } catch (e: ResponseException) {
            AllPostsResponse(
                postsList = emptyList(),
                isSuccess = false,
                errorMessage = "${e.response.status}",
            )
        } catch (e: Exception) {
            AllPostsResponse(
                postsList = emptyList(),
                isSuccess = false,
                errorMessage = "${e.message}",
            )
        }

    override suspend fun setUserPost(
        userId: Int,
        title: String,
        content: String,
    ): CreatePostResponse =
        try {
            val response =
                apiService.setUserPost(
                    userId = userId,
                    title = title,
                    content = content,
                )
            CreatePostResponse(
                createPost = response.body(),
                isSuccess = response.status.isSuccess(),
            )
        } catch (e: ServerResponseException) {
            CreatePostResponse(
                createPost = null,
                isSuccess = false,
                errorMessage = "${e.response.status}",
            )
        } catch (e: ResponseException) {
            CreatePostResponse(
                createPost = null,
                isSuccess = false,
                errorMessage = "${e.response.status}",
            )
        } catch (e: Exception) {
            val error = e
            CreatePostResponse(
                createPost = null,
                isSuccess = false,
                errorMessage = "${e.message}",
            )
        }
}
