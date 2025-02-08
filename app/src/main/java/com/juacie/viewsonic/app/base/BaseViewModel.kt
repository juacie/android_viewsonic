package com.juacie.viewsonic.app.base

import androidx.lifecycle.ViewModel
import com.juacie.viewsonic.app.kit.function.LogObj
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: MutableStateFlow<Boolean> = _isLoading

    fun showLoadingView(isLoading: Boolean) {
        _isLoading.value = isLoading
    }

    fun handleError(exception: Exception) {
        LogObj.trace(exception.message.toString())
    }
}