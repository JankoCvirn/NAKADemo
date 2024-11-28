package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.nakademo.usecase.UserCrudUseCaseImpl
import db.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val userUseCase: UserCrudUseCaseImpl,
) : ViewModel() {
    private val _allUsersFlow = MutableStateFlow<List<User>>(emptyList())
    val allUsersFlow: StateFlow<List<User>> = _allUsersFlow

    fun loadUsers() {
        viewModelScope.launch {
            userUseCase.getAll().collect {
                _allUsersFlow.value = it
            }
        }
    }
}
