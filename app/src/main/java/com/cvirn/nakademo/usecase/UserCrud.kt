package com.cvirn.nakademo.usecase

import db.User
import kotlinx.coroutines.flow.Flow

interface UserCrud {
    suspend fun addUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun deleteUser(userId: Long)

    suspend fun getAll(): Flow<List<User>>
}
