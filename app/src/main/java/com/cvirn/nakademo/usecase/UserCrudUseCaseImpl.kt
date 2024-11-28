package com.cvirn.nakademo.usecase

import com.cvirn.local.LocalDataRepositoryImpl
import db.User
import kotlinx.coroutines.flow.Flow

class UserCrudUseCaseImpl(
    private val localDataRepositoryImpl: LocalDataRepositoryImpl
) : UserCrud {
    override suspend fun addUser(user: User) {
        localDataRepositoryImpl.addUser(user = user)
    }

    override suspend fun updateUser(user: User) {
        localDataRepositoryImpl.updateUser(user = user)
    }

    override suspend fun deleteUser(userId: Long) {
        localDataRepositoryImpl.deleteUser(userId = userId)
    }

    override suspend fun getAll(): Flow<List<User>> {
        return localDataRepositoryImpl.getAllUsers()
    }
}