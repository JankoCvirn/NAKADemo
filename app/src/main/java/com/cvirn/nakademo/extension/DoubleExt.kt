package com.cvirn.nakademo.extension

fun Double.toDegree(): Int = (360 * this / 100).toInt()
