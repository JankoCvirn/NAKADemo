package com.cvirn.nakademo.component.snackbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming")
@Composable
fun CustomSnackbar(
    snackbarData: SnackbarData,
    message: String,
) {
    Snackbar(
        action = {
            TextButton(onClick = { snackbarData.dismiss() }) {
                Text("DISMISS")
            }
        },
        modifier = Modifier.padding(16.dp),
    ) {
        Text(text = message)
    }
}
