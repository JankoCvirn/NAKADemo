package com.cvirn.nakademo.screen.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvirn.nakademo.component.UserCard
import com.cvirn.nakademo.ui.theme.NAKADemoTheme
import com.cvirn.task4me.ui.values.LocalPaddingValues
import db.User

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreenContent(
    userList: List<User>,
    onNavigateToCreate: () -> Unit,
    onNavigateToUpdate: (User?) -> Unit,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.padding(LocalPaddingValues.current.small),
            verticalArrangement = Arrangement.spacedBy(LocalPaddingValues.current.large),
        ) {
            items(userList) {
                UserCard(it, onClick = { onNavigateToUpdate(it) })
            }
        }
        FloatingActionButton(
            onClick = onNavigateToCreate,
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(LocalPaddingValues.current.large)
                    .size(68.dp),
            shape = MaterialTheme.shapes.extraLarge,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(48.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "contentDescription",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark",
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight",
)
@Composable
fun PreviewHomeScreenContent() {
    NAKADemoTheme {
        HomeScreenContent(
            userList =
                listOf(
                    User(
                        id = 100L,
                        firstname = "Anna",
                        lastname = "Bauer",
                        age = 32,
                        gender = 0,
                    ),
                    User(
                        id = 100L,
                        firstname = "Josip",
                        lastname = "Bauer",
                        age = 41,
                        gender = 1,
                    ),
                ),
            {},
            {},
        )
    }
}
