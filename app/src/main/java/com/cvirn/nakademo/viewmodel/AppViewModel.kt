package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel : ViewModel() {
    @Suppress("ktlint:standard:backing-property-naming")
    private val _errorSnackBarFlow = MutableStateFlow(false)
    val errorSnackBarFlow: StateFlow<Boolean> = _errorSnackBarFlow

    fun showSnackBarMessage() {
        viewModelScope.launch {
            _errorSnackBarFlow.value = true
        }
    }
}
