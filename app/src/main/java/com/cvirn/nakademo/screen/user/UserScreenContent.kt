package com.cvirn.nakademo.screen.user

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import com.cvirn.nakademo.R
import com.cvirn.nakademo.component.RadioButtonGroup
import com.cvirn.nakademo.extension.toStateLong
import com.cvirn.nakademo.extension.toStateString
import com.cvirn.nakademo.viewmodel.UserScreenViewModel
import com.cvirn.task4me.ui.values.LocalPaddingValues

@Suppress("ktlint:standard:function-naming")
@Composable
fun UserScreenContent(
    userScreenViewModel: UserScreenViewModel,
    onNavigateBack: () -> Boolean,
) {
    val context = LocalContext.current
    val userState by userScreenViewModel.userViewState.collectAsState()

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(LocalPaddingValues.current.large),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedVisibility(userState.hasErrors ?: false) {
            Text(
                text = stringResource(R.string.action_error),
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
        OutlinedTextField(
            value = userState.firstName,
            onValueChange = { userScreenViewModel.updateFirstName(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.user_first_name_placeholder)) },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
        )

        OutlinedTextField(
            value = userState.lastName,
            onValueChange = { userScreenViewModel.updateLastName(it) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.user_last_name_placeholder)) },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
        )

        OutlinedTextField(
            value = userState.age,
            onValueChange = { age ->
                userScreenViewModel.updateAge(age)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(R.string.user_age_placeholder)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
        )

        RadioButtonGroup(
            radioOptions =
                listOf(
                    stringResource(R.string.user_genger_male),
                    stringResource(R.string.user_gender_female),
                ),
            selectedOption = userState.gender.toStateString(context),
            onOptionSelected = { gender ->
                userScreenViewModel.updateGender(gender.toStateLong(context))
            },
        )

        Spacer(modifier = Modifier.height(LocalPaddingValues.current.large))
        if (userState.id == null) {
            CreateUserButtons(
                addNewUser = {
                    if (userScreenViewModel.addNewUser()) {
                        onNavigateBack()
                    }
                },
            )
        } else {
            UpdateUserButtons(
                updateUser = {
                    if (userScreenViewModel.updateUser()) {
                        onNavigateBack()
                    }
                },
                deleteUser = {
                    userScreenViewModel.deleteUser()
                    onNavigateBack()
                },
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
private fun UpdateUserButtons(
    updateUser: () -> Unit,
    deleteUser: () -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(LocalPaddingValues.current.large),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Button(onClick = {
            updateUser()
        }) {
            Text(
                text = stringResource(R.string.action_update),
                style = MaterialTheme.typography.labelMedium,
            )
        }
        Button(onClick = {
            deleteUser()
        }) {
            Text(
                text = stringResource(R.string.action_delete),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
private fun CreateUserButtons(addNewUser: () -> Unit) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(LocalPaddingValues.current.large),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Button(onClick = {
            addNewUser()
        }) {
            Text(
                text = stringResource(R.string.action_create),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}
