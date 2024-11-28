package com.cvirn.remote.repository

import com.cvirn.remote.model.AllUsersResponse

interface RemoteRepository {
    suspend fun getAllUsers(): AllUsersResponse
}
