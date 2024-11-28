package com.cvirn.remote.service

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiServiceImpl(
    private val client: HttpClient,
) {
    suspend fun getAllUsers() = client.get(USERS_END_POINT)

    companion object {
        private const val USERS_END_POINT =
            "https://jsonplaceholder.typicode.com/users"
    }
}
