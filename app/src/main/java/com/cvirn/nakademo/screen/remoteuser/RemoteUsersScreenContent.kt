package com.cvirn.nakademo.screen.remoteuser

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvirn.nakademo.component.UserCard
import com.cvirn.nakademo.ui.theme.NAKADemoTheme
import com.cvirn.remote.model.User
import com.cvirn.task4me.ui.values.LocalPaddingValues

@Suppress("ktlint:standard:function-naming")
@Composable
fun RemoteUsersScreenContent(
    paddingValues: PaddingValues,
    screenState: RemoteUserScreenState,
    onNavigateToUsersPost: (User) -> Unit,
    onNavigateToCreatePost: (User) -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
    ) {
        LazyColumn(
            modifier = Modifier.padding(LocalPaddingValues.current.small),
            verticalArrangement = Arrangement.spacedBy(LocalPaddingValues.current.large),
        ) {
            items(screenState.userList) {

            }
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark",
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight",
)
@Composable
fun PreviewRemoteUsersScreenContent() {
    NAKADemoTheme {
        val paddingValues = PaddingValues(16.dp)
    }
}
