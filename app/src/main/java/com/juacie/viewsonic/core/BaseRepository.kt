package com.juacie.viewsonic.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

open class BaseRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): ResultWrapper<T> {
        return try {
            val response = withContext(Dispatchers.IO) { apiCall() }
            ResultWrapper.Success(response)
        } catch (e: IOException) {
            ResultWrapper.Error("Network Error", e)
        } catch (e: Exception) {
            ResultWrapper.Error("Unknown Error", e)
        }
    }
}