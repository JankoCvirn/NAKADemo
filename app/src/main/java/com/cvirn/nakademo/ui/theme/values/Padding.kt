package com.cvirn.task4me.ui.values

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class PaddingValues(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 24.dp,
)

// Provide a default instance
val DefaultPaddingValues = PaddingValues()

// Create a CompositionLocal to access padding values
val LocalPaddingValues = staticCompositionLocalOf { DefaultPaddingValues }
