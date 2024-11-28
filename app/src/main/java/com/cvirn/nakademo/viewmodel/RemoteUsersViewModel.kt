package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.nakademo.screen.remoteuser.RemoteUserScreenState
import com.cvirn.remote.repository.RemoteRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RemoteUsersViewModel(
    private val remoteRepositoryImpl: RemoteRepositoryImpl,
) : ViewModel() {
    private val _allRemoteUsers =
        MutableStateFlow(
            RemoteUserScreenState(
                userList = emptyList(),
                isSuccess = true,
            ),
        )
    val allRemoteUsers: StateFlow<RemoteUserScreenState> = _allRemoteUsers

    fun loadUsers() {
        viewModelScope.launch {
            val result = remoteRepositoryImpl.getAllUsers()
            _allRemoteUsers.value =
                RemoteUserScreenState(
                    userList = result.usersList,
                    isSuccess = result.isSuccess,
                )
        }
    }
}
