package com.cvirn.remote.repository

import com.cvirn.remote.model.AllUsersResponse
import com.cvirn.remote.model.User
import com.cvirn.remote.service.ApiServiceImpl
import io.ktor.client.call.body
import io.ktor.http.isSuccess

class RemoteRepositoryImpl(
    private val apiService: ApiServiceImpl,
) : RemoteRepository {
    override suspend fun getAllUsers(): AllUsersResponse {
        val response = apiService.getAllUsers()
        val list: List<User> = response.body()
        return AllUsersResponse(
            usersList = list,
            isSuccess = response.status.isSuccess(),
        )
    }
}
