package com.cvirn.local

import app.cash.sqldelight.coroutines.asFlow
import db.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import sqldelight.db.Database

class LocalDataRepositoryImpl(
    database: Database,
) : LocalDataRepository {
    private val userQueries = database.userQueries

    override fun getAllUsers(): Flow<List<User>> =
        userQueries.selectAllUsers().asFlow().map {
            it.executeAsList()
        }

    override fun addUser(user: User) {
        userQueries.insertUser(
            id = null,
            firstname = user.firstname,
            lastname = user.lastname,
            age = user.age,
            gender = user.gender,
        )
    }

    override fun updateUser(user: User) {
        userQueries.updateUser(
            id = user.id,
            firstname = user.firstname,
            lastname = user.lastname,
            age = user.age,
            gender = user.gender,
        )
    }

    override fun deleteUser(userId: Long) {
        userQueries.deleteUser(id = userId)
    }
}
