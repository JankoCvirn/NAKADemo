package com.cvirn.remote.model.userpost

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreatePost(
    @SerialName("id")
    val id: Int,
)
