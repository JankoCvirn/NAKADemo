package com.cvirn.local

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import db.User
import db.UserQueries
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import io.mockk.verify
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import sqldelight.db.Database

class LocalDataRepositoryImplTest {
    private lateinit var database: Database
    private lateinit var userQueries: UserQueries
    private lateinit var repository: LocalDataRepositoryImpl

    @Before
    fun setup() {
        database = mockk()
        userQueries = mockk(relaxed = true)
        every { database.userQueries } returns userQueries
        repository = LocalDataRepositoryImpl(database)
    }

    @After
    fun teardown() {
        unmockkAll()
    }

    @Test
    fun `getAllUsers should return a flow of user list`() =
        runBlocking {
            val mockUsers =
                listOf(
                    User(id = 1, firstname = "John", lastname = "Doe", age = 30, gender = 0),
                    User(id = 2, firstname = "Jane", lastname = "Doe", age = 28, gender = 1),
                )

            val mockQuery =
                mockk<Query<User>> {
                    every { executeAsList() } returns mockUsers
                }

            every { userQueries.selectAllUsers() } returns mockQuery

            mockkStatic("app.cash.sqldelight.coroutines.FlowQuery")
            every { mockQuery.asFlow() } returns flowOf(mockQuery)

            val resultFlow: Flow<List<User>> = repository.getAllUsers()

            val result = resultFlow.first() // Collect the first emission
            assertEquals(mockUsers, result)

            verify { userQueries.selectAllUsers() }
            verify { mockQuery.executeAsList() }
        }

    @Test
    fun `addUser should insert user into database`() {
        val user = User(id = 100L, firstname = "John", lastname = "Doe", age = 30, gender = 0)

        repository.addUser(user)

        verify {
            userQueries.insertUser(
                id = null,
                firstname = user.firstname,
                lastname = user.lastname,
                age = user.age,
                gender = user.gender,
            )
        }
    }

    @Test
    fun `updateUser should update the user in database`() {
        val user = User(id = 1, firstname = "John", lastname = "Smith", age = 31, gender = 0)

        repository.updateUser(user)

        verify {
            userQueries.updateUser(
                id = user.id,
                firstname = user.firstname,
                lastname = user.lastname,
                age = user.age,
                gender = user.gender,
            )
        }
    }

    @Test
    fun `deleteUser should delete user from database by id`() {
        val userId = 1L

        repository.deleteUser(userId)

        verify { userQueries.deleteUser(id = userId) }
    }
}
