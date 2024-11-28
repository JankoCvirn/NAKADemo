package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.nakademo.screen.user.UserScreenState
import com.cvirn.nakademo.usecase.UserCrudUseCaseImpl
import db.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserScreenViewModel(
    private val userUseCase: UserCrudUseCaseImpl
) : ViewModel() {

    private val _userViewState = MutableStateFlow(UserScreenState())
    val userViewState: StateFlow<UserScreenState> = _userViewState

    fun setUserState(user: User) {
        _userViewState.value = UserScreenState(
            firstName = user.firstname,
            lastName = user.lastname,
            age = user.age.toString(),
            gender = user.gender,
            id = user.id
        )
    }

    fun updateFirstName(firstName: String) {
        _userViewState.value = _userViewState.value.copy(firstName = firstName)
    }

    fun updateLastName(lastName: String) {
        _userViewState.value = _userViewState.value.copy(lastName = lastName)
    }

    fun updateAge(age: String) {
        _userViewState.value = _userViewState.value.copy(age = age)
    }

    fun updateGender(gender: Long) {
        _userViewState.value = _userViewState.value.copy(gender = gender)
    }

    fun addNewUser(): Boolean {
        return if (allEntriesValid()) {
            viewModelScope.launch {
                userUseCase.addUser(
                    User(
                        firstname = userViewState.value.firstName,
                        lastname = userViewState.value.lastName,
                        age = userViewState.value.age.toLong(),
                        gender = userViewState.value.gender,
                        id = 100L
                    )
                )
            }
            true
        } else {
            false
        }
    }

    fun updateUser(): Boolean {
        return if (allEntriesValid()) {
            viewModelScope.launch {
                if (allEntriesValid()) {
                    userUseCase.updateUser(
                        User(
                            firstname = userViewState.value.firstName,
                            lastname = userViewState.value.lastName,
                            age = userViewState.value.age.toLong(),
                            gender = userViewState.value.gender,
                            id = userViewState.value.id ?: 0
                        )
                    )
                }
            }
            true
        } else {
            false
        }
    }

    fun deleteUser() {
        viewModelScope.launch {
            userViewState.value.id?.let {
                userUseCase.deleteUser(it)
            }
        }
    }

    private fun allEntriesValid(): Boolean {
        return if (userViewState.value.isValid()) {
            _userViewState.value = _userViewState.value.copy(hasErrors = false)
            true
        } else {
            _userViewState.value = _userViewState.value.copy(hasErrors = true)
            false
        }
    }

    private fun UserScreenState.isValid(): Boolean {
        return firstName.isNotBlank() &&
                lastName.isNotBlank() &&
                age.toIntOrNull()?.let { it in MIN_AGE..MAX_AGE } ?: false
    }

    companion object {
        const val MIN_AGE = 1
        const val MAX_AGE = 120
    }
}