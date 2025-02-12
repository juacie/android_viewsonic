package com.juacie.viewsonic.domain

import com.juacie.viewsonic.core.ResultWrapper
import com.juacie.viewsonic.data.model.Calculation
import com.juacie.viewsonic.data.model.Conversion
import com.juacie.viewsonic.data.model.DateTimeInfo
import com.juacie.viewsonic.data.model.TimeZoneData
import com.juacie.viewsonic.data.repository.TimeRepository

class TimeUseCase(private val repository: TimeRepository) {
    //==============================================================================================
    //region Time

    suspend fun getTimeByZone(timeZone: String): ResultWrapper<DateTimeInfo> {
        val result = repository.getTimeByZone(timeZone)
        return result
    }

    suspend fun getTimeByCoordinate(
        latitude: Float,
        longitude: Float
    ): ResultWrapper<DateTimeInfo> {
        val result = repository.getTimeByCoordinate(latitude, longitude)
        return result
    }

    suspend fun getTimeByIp(ipAddress: String): ResultWrapper<DateTimeInfo> {
        val result = repository.getTimeByIp(ipAddress)
        return result
    }
    //endregion
    //==============================================================================================
    //region time zone

    suspend fun getTimeZoneList(): List<String> {
        val result = repository.getTimeZoneList()
        return if (result is ResultWrapper.Success) {
            result.data
        } else {
            emptyList()
        }
    }

    suspend fun getZoneInfoByZone(timeZone: String): ResultWrapper<TimeZoneData> {
        val result = repository.getZoneInfoByZone(timeZone)
        return result
    }

    suspend fun getZoneInfoByCoordinate(
        latitude: Float,
        longitude: Float
    ): ResultWrapper<TimeZoneData> {
        val result = repository.getZoneInfoByCoordinate(latitude, longitude)
        return result
    }

    suspend fun getZoneInfoByIp(ipAddress: String): ResultWrapper<TimeZoneData> {
        val result = repository.getZoneInfoByIp(ipAddress)
        return result
    }
    //endregion
    //==============================================================================================
    //region Conversion

    suspend fun postConvertTimeZone(request: Conversion.ConvertRequest): ResultWrapper<Conversion.Conversion> {
        val result = repository.postConvertTimeZone(request)
        return result
    }

    suspend fun postTranslate(request: Conversion.TranslationRequest): ResultWrapper<Conversion.Translation> {
        val result = repository.postTranslate(request)
        return result
    }

    suspend fun getWeekdayOfDate(date: String): ResultWrapper<Conversion.DayOfTheWeekResult> {
        val result = repository.getWeekdayOfDate(date)
        return result
    }

    suspend fun getDayOfYear(date: String): ResultWrapper<Conversion.DayOfYearResponse> {
        val result = repository.getDayOfYear(date)
        return result
    }
    //endregion
    //==============================================================================================
    //region Calculation

    suspend fun postIncrementCurrentDateTime(request: Calculation.CurrentRequest): ResultWrapper<Calculation.Calculation> {
        val result = repository.postIncrementCurrentDateTime(request)
        return result
    }

    suspend fun postDecrementCurrentDateTime(request: Calculation.CurrentRequest): ResultWrapper<Calculation.Calculation> {
        val result = repository.postDecrementCurrentDateTime(request)
        return result
    }

    suspend fun postIncrementCustomDateTime(request: Calculation.CustomRequest): ResultWrapper<Calculation.Calculation> {
        val result = repository.postIncrementCustomDateTime(request)
        return result
    }

    suspend fun postDecrementCustomDateTime(request: Calculation.CustomRequest): ResultWrapper<Calculation.Calculation> {
        val result = repository.postDecrementCustomDateTime(request)
        return result
    }
    //endregion
    //==============================================================================================
    //region Health

    suspend fun getHealthCheck(): Boolean {
        val result = repository.getHealthCheck()
        return result is ResultWrapper.Success
    }
    //endregion
    //==============================================================================================
}