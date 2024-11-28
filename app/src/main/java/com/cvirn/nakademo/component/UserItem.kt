package com.cvirn.nakademo.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cvirn.nakademo.R
import com.cvirn.nakademo.extension.toStateString
import com.cvirn.nakademo.ui.theme.NAKADemoTheme
import com.cvirn.task4me.ui.values.LocalPaddingValues
import db.User

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserCard(
    user: User,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val context = LocalContext.current
    Card(
        modifier =
            modifier
                .padding(
                    horizontal = LocalPaddingValues.current.large,
                    vertical = LocalPaddingValues.current.medium,
                ).semantics { }
                .clickable { onClick() },
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(LocalPaddingValues.current.small),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier =
                        modifier
                            .size(64.dp),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.inversePrimary),
                )
                Column(
                    modifier =
                        Modifier
                            .weight(1f)
                            .padding(
                                horizontal = LocalPaddingValues.current.large,
                                vertical = LocalPaddingValues.current.small,
                            ),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = stringResource(R.string.user_name, user.firstname, user.lastname),
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Text(
                        text = user.gender.toStateString(context),
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Text(
                        text = stringResource(R.string.user_age, user.age),
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }
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
fun PreviewUserCard() {
    NAKADemoTheme {
        UserCard(
            user =
                User(
                    id = 100L,
                    firstname = "Anna",
                    lastname = "Bauer",
                    age = 32,
                    gender = 0,
                ),
            onClick = {},
        )
    }
}
