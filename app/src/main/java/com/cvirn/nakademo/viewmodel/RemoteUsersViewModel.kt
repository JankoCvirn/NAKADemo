package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.nakademo.screen.remoteuser.RemoteUserScreenState
import com.cvirn.nakademo.usecase.RemoteUserUseCaseImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RemoteUsersViewModel(
    private val remoteUserUseCaseImpl: RemoteUserUseCaseImpl,
) : ViewModel() {
    private val _allRemoteUsers =
        MutableStateFlow(
            RemoteUserScreenState(
                userList = emptyList(),
                isSuccess = true,
            ),
        )
    val allRemoteUsers: StateFlow<RemoteUserScreenState> = _allRemoteUsers

    fun loadRemoteUsers() {
        viewModelScope.launch {
            val result = remoteUserUseCaseImpl.getAllRemoteUsers()
            _allRemoteUsers.value =
                RemoteUserScreenState(
                    userList = result.usersList,
                    isSuccess = result.isSuccess,
                    error = result.errorMessage,
                )
        }
    }
}
