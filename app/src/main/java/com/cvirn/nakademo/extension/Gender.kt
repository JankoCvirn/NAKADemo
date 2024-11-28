package com.cvirn.nakademo.extension

import android.content.Context
import com.cvirn.nakademo.R

fun Long.toStateString(context: Context): String =
    when (this) {
        0L -> context.getString(R.string.user_gender_female)
        1L -> context.getString(R.string.user_genger_male)
        else -> throw IllegalArgumentException("Invalid state value: $this")
    }

fun String.toStateLong(context: Context): Long =
    when (this) {
        context.getString(R.string.user_gender_female) -> 0L
        context.getString(R.string.user_genger_male) -> 1L
        else -> throw IllegalArgumentException("Invalid state value: $this")
    }
