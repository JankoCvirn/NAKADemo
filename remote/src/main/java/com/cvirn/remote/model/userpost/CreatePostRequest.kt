package com.cvirn.remote.model.userpost

import kotlinx.serialization.Serializable

@Serializable
data class CreatePostRequest(
    val title: String,
    val body: String,
    val userId: Int,
)
