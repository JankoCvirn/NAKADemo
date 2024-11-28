package com.cvirn.nakademo.screen.remoteuser

import com.cvirn.remote.model.User

data class RemoteUserScreenState(
    val userList: List<User>,
    val isSuccess: Boolean,
)
