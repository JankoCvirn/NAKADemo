package com.cvirn.remote.model.user

data class AllUsersResponse(
    val usersList: List<User>,
    val isSuccess: Boolean,
    val errorMessage: String? = "",
)
