package com.cvirn.nakademo.screen.remoteuser

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cvirn.nakademo.component.RemoteUserCard
import com.cvirn.task4me.ui.values.LocalPaddingValues

@Suppress("ktlint:standard:function-naming")
@Composable
fun RemoteUsersScreenContent(
    paddingValues: PaddingValues,
    screenState: RemoteUserScreenState,
    onNavigateToUsersPost: (Int?) -> Unit,
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
                RemoteUserCard(it, onClick = { onNavigateToUsersPost(it.id) })
            }
        }
    }
}
