package com.cvirn.nakademo.usecase

import com.cvirn.nakademo.screen.posts.UserPostsScreenState
import com.cvirn.remote.model.userpost.AllPostsItem
import com.cvirn.remote.repository.RemoteRepositoryImpl

class RemoteUserUseCaseImpl(
    private val remoteRepositoryImpl: RemoteRepositoryImpl,
) : RemoteUser {
    override suspend fun getAllRemoteUsers() = remoteRepositoryImpl.getAllUsers()

    override suspend fun getAllPostsForUser(userId: Int): UserPostsScreenState {
        val allPostsResult = remoteRepositoryImpl.getAllPosts()
        val filterPosts = filterUserPosts(userId = userId, allPostsResult.postsList)
        return UserPostsScreenState(
            postList = filterPosts,
            isSuccess = allPostsResult.isSuccess,
            error = allPostsResult.errorMessage,
        )
    }

    override suspend fun setUserPost(
        userId: Int,
        title: String,
        content: String,
    ): Boolean {
        val result =
            remoteRepositoryImpl.setUserPost(
                userId = userId,
                title = title,
                content = content,
            )
        return result.isSuccess
    }

    private fun filterUserPosts(
        userId: Int,
        postList: List<AllPostsItem>,
    ) = postList.filter { it.userId == userId }
}
