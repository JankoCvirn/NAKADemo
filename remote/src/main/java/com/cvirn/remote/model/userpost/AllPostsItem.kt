package com.cvirn.remote.model.userpost

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllPostsItem(
    @SerialName("body")
    val body: String,
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("userId")
    val userId: Int,
)
