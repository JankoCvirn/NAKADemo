package com.cvirn.nakademo.screen.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.MaterialTheme
import com.cvirn.nakademo.R
import com.cvirn.nakademo.screen.home.HomeScreen
import com.cvirn.nakademo.screen.remoteuser.RemoteUsersScreen
import db.User

@Suppress("ktlint:standard:function-naming")
@Composable
fun TabsWithScreens(
    onNavigateToCreate: () -> Unit,
    onNavigateToUpdate: (User?) -> Unit,
    onNavigateToUsersPost: (Int?) -> Unit,
) {
    val tabs =
        listOf(stringResource(R.string.tab_local_users), stringResource(R.string.tab_remote_users))
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize().padding(top = 96.dp)) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title, style = MaterialTheme.typography.titleMedium) },
                )
            }
        }

        when (selectedTabIndex) {
            0 ->
                HomeScreen(
                    onNavigateToCreate = onNavigateToCreate,
                    onNavigateToUpdate = onNavigateToUpdate,
                )

            1 ->
                RemoteUsersScreen(
                    onNavigateToUsersPost = onNavigateToUsersPost,
                )
        }
    }
}
