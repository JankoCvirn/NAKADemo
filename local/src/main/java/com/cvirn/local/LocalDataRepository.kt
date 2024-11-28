package com.cvirn.local

import db.User
import kotlinx.coroutines.flow.Flow

interface LocalDataRepository {
    fun getAllUsers(): Flow<List<User>>

    fun addUser(user: User)

    fun updateUser(user: User)

    fun deleteUser(userId: Long)
}
