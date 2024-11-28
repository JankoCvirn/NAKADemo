package com.cvirn.remote.model

data class AllUsersResponse(
    val usersList: List<User>,
    val isSuccess: Boolean,
)
