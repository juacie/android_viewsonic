package com.juacie.viewsonic.data.repository

import com.juacie.viewsonic.core.BaseRepository
import com.juacie.viewsonic.core.ResultWrapper
import com.juacie.viewsonic.data.model.Calculation
import com.juacie.viewsonic.data.model.Conversion
import com.juacie.viewsonic.data.model.DateTimeInfo
import com.juacie.viewsonic.data.model.TimeZoneData
import com.juacie.viewsonic.data.network.ApiService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TimeRepository : BaseRepository(), KoinComponent {
    //==============================================================================================
    //region declare

    private val apiService: ApiService by inject()
    //endregion
    //==============================================================================================
    //region Time

    suspend fun getTimeByZone(timeZone: String): ResultWrapper<DateTimeInfo> {
        return safeApiCall { apiService.svGetTimeByZone(timeZone) }
    }

    suspend fun getTimeByCoordinate(
        latitude: Float,
        longitude: Float
    ): ResultWrapper<DateTimeInfo> {
        return safeApiCall { apiService.svGetTimeByCoordinate(latitude, longitude) }
    }

    suspend fun getTimeByIp(ipAddress: String): ResultWrapper<DateTimeInfo> {
        return safeApiCall { apiService.svGetTimeByIp(ipAddress) }
    }
    //endregion
    //==============================================================================================
    //region time zone

    suspend fun getTimeZoneList(): ResultWrapper<List<String>> {
        return safeApiCall { apiService.svGetTimeZoneList() }
    }

    suspend fun getZoneInfoByZone(timeZone: String): ResultWrapper<TimeZoneData> {
        return safeApiCall { apiService.svGetZoneInfoByZone(timeZone) }
    }

    suspend fun getZoneInfoByCoordinate(
        latitude: Float,
        longitude: Float
    ): ResultWrapper<TimeZoneData> {
        return safeApiCall { apiService.svGetZoneInfoByCoordinate(latitude, longitude) }
    }

    suspend fun getZoneInfoByIp(ipAddress: String): ResultWrapper<TimeZoneData> {
        return safeApiCall { apiService.svGetZoneInfoByIp(ipAddress) }
    }
    //endregion
    //==============================================================================================
    //region Conversion

    suspend fun postConvertTimeZone(request: Conversion.ConvertRequest): ResultWrapper<Conversion.Conversion> {
        return safeApiCall { apiService.svPostConvertTimeZone(request) }
    }

    suspend fun postTranslate(request: Conversion.TranslationRequest): ResultWrapper<Conversion.Translation> {
        return safeApiCall { apiService.svPostTranslate(request) }
    }

    suspend fun getWeekdayOfDate(date: String): ResultWrapper<Conversion.DayOfTheWeekResult> {
        return safeApiCall { apiService.svGetWeekdayOfDate(date) }
    }

    suspend fun getDayOfYear(date: String): ResultWrapper<Conversion.DayOfYearResponse> {
        return safeApiCall { apiService.svGetDayOfYear(date) }
    }
    //endregion
    //==============================================================================================
    //region Calculation

    suspend fun postIncrementCurrentDateTime(request: Calculation.CurrentRequest): ResultWrapper<Calculation.Calculation> {
        return safeApiCall { apiService.svPostIncrementCurrentDateTime(request) }
    }

    suspend fun postDecrementCurrentDateTime(request: Calculation.CurrentRequest): ResultWrapper<Calculation.Calculation> {
        return safeApiCall { apiService.svPostDecrementCurrentDateTime(request) }
    }

    suspend fun postIncrementCustomDateTime(request: Calculation.CustomRequest): ResultWrapper<Calculation.Calculation> {
        return safeApiCall { apiService.svPostIncrementCustomDateTime(request) }
    }

    suspend fun postDecrementCustomDateTime(request: Calculation.CustomRequest): ResultWrapper<Calculation.Calculation> {
        return safeApiCall { apiService.svPostDecrementCustomDateTime(request) }
    }
    //endregion
    //==============================================================================================
    //region Health

    suspend fun getHealthCheck(): ResultWrapper<String> {
        return safeApiCall { apiService.svGetHealthCheck() }
    }
    //endregion
    //==============================================================================================
}