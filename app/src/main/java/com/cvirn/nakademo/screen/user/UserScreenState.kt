package com.cvirn.nakademo.screen.user

data class UserScreenState(
    val firstName: String = "",
    val lastName: String = "",
    val age: String = "",
    val gender: Long = 0,
    val id: Long? = null,
    var hasErrors: Boolean? = false,
)
