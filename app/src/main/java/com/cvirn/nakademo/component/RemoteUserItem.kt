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
import com.cvirn.nakademo.ui.theme.NAKADemoTheme
import com.cvirn.remote.model.user.Address
import com.cvirn.remote.model.user.Company
import com.cvirn.remote.model.user.Geo
import com.cvirn.remote.model.user.User
import com.cvirn.task4me.ui.values.LocalPaddingValues

@Suppress("ktlint:standard:function-naming")
@Composable
fun RemoteUserCard(
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
                        text = stringResource(R.string.remote_user_name, user.name),
                        style = MaterialTheme.typography.bodyMedium,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Text(
                        text = stringResource(R.string.remote_user_contact, user.phone, user.email),
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Text(
                        text =
                            stringResource(
                                R.string.remote_user_company,
                                user.company.name,
                                user.address.city,
                                user.address.suite,
                            ),
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                    Text(
                        text = user.company.catchPhrase,
                        style = MaterialTheme.typography.bodyMedium,
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
fun PreviewRemoteUserCard() {
    NAKADemoTheme {
        RemoteUserCard(
            user =
                User(
                    id = 100,
                    name = "John Doe",
                    username = "john.doe",
                    email = "john.doe@gmail.com",
                    phone = "++11000456987",
                    website = "www.google.com",
                    company =
                        Company(
                            name = "Google",
                            bs = "bs",
                            catchPhrase = "Xoxoho",
                        ),
                    address =
                        Address(
                            suite = "Suite 12A",
                            city = "Los Alamos",
                            geo = Geo("", ""),
                            street = "Street A",
                            zipcode = "1000",
                        ),
                ),
            onClick = {},
        )
    }
}
