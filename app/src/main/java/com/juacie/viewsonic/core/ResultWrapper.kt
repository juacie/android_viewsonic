package com.juacie.viewsonic.core

sealed class ResultWrapper<out T> {
    data class Success<T>(val data: T) : ResultWrapper<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : ResultWrapper<Nothing>()
    object Loading : ResultWrapper<Nothing>()
}