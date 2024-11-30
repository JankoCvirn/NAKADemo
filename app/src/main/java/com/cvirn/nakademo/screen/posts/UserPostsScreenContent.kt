package com.cvirn.nakademo.screen.posts

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cvirn.nakademo.R
import com.cvirn.nakademo.component.PostCard
import com.cvirn.nakademo.component.dialog.CreatePostDialog
import com.cvirn.nakademo.viewmodel.UserPostsViewModel
import com.cvirn.task4me.ui.values.LocalPaddingValues

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserPostsScreenContent(
    padding: PaddingValues,
    userId: Int,
    userPostViewModel: UserPostsViewModel,
) {
    var showDialog by remember { mutableStateOf(false) }
    val postList by userPostViewModel.allUserPosts.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val successMessage = stringResource(R.string.create_post_sucess)
    val failureMessage = stringResource(R.string.create_post_failed)

    LaunchedEffect(postList.showCreatePostSnackBar) {
        postList.showCreatePostSnackBar?.let {
            val message =
                if (postList.isCreatePostSuccess == true) {
                    successMessage
                } else {
                    failureMessage
                }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(padding),
    ) {
        LazyColumn(
            modifier = Modifier.padding(LocalPaddingValues.current.small),
            verticalArrangement = Arrangement.spacedBy(LocalPaddingValues.current.large),
        ) {
            items(postList.postList) {
                PostCard(it)
            }
        }
        FloatingActionButton(
            onClick = { showDialog = true },
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
        CreatePostDialog(
            showDialog = showDialog,
            onDismiss = { showDialog = false },
            onConfirm = { title, content ->
                userPostViewModel.createPost(
                    title = title,
                    content = content,
                    userId = userId,
                )
            },
        )
    }
}
