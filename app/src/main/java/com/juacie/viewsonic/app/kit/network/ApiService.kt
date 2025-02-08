package com.juacie.viewsonic.app.kit.network

import com.juacie.viewsonic.app.main.model.Calculation
import com.juacie.viewsonic.app.main.model.Conversion
import com.juacie.viewsonic.app.main.model.DateTimeInfo
import com.juacie.viewsonic.app.main.model.TimeZoneData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    //==============================================================================================
    //region Time

    /**
     * Retrieves the current time for a specific time zone.
     *
     * @param timeZone The IANA time zone name. Example: "Europe/Amsterdam"
     * @return The current time in the specified time zone wrapped in a Response object.
     */
    @GET("/api/time/current/zone")
    suspend fun svGetTimeByZone(@Query("timeZone") timeZone: String): Response<DateTimeInfo>

    /**
     * Retrieves the current time for a location using latitude and longitude coordinates.
     *
     * @param latitude The latitude ranging from -90 to 90.
     * @param longitude The longitude ranging from -180 to 180.
     * @return The current time at the specified geo-location.
     */
    @GET("/api/time/current/coordinate")
    suspend fun svGetTimeByCoordinate(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float
    ): Response<DateTimeInfo>

    /**
     * Retrieves the current time for a location using the IP address.
     *
     * @param ipAddress The IPv4 address. Example: "237.71.232.203".
     * @return The current time at the location associated with the provided IP address.
     */
    @GET("/api/time/current/ip")
    suspend fun svGetTimeByIp(@Query("ipAddress") ipAddress: String): Response<DateTimeInfo>
    //endregion
    //==============================================================================================
    //region TimeZone

    /**
     * Retrieves the list of all available IANA time zones.
     *
     * @return A list of time zone names in the IANA format.
     */
    @GET("/api/timezone/availabletimezones")
    suspend fun svGetTimeZoneList(): Response<List<String>>

    /**
     * Retrieves time zone details for a specific IANA time zone.
     *
     * @param timeZone The IANA time zone name. Example: "Europe/Amsterdam".
     * @return The details of the requested time zone.
     */
    @GET("/api/timezone/zone")
    suspend fun svGetZoneInfoByZone(@Query("timeZone") timeZone: String): Response<TimeZoneData>

    /**
     * Retrieves time zone details for a specific location based on latitude and longitude.
     *
     * @param latitude The latitude ranging from -90 to 90.
     * @param longitude The longitude ranging from -180 to 180.
     * @return The time zone details for the location defined by the coordinates.
     */
    @GET("/api/timezone/coordinate")
    suspend fun svGetZoneInfoByCoordinate(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float
    ): Response<TimeZoneData>

    /**
     * Retrieves time zone details for a specific location based on its IP address.
     *
     * @param ipAddress The IPv4 address. Example: "237.71.232.203".
     * @return The time zone information based on the provided IP address.
     */
    @GET("/api/timezone/ip")
    suspend fun svGetZoneInfoByIp(@Query("ipAddress") ipAddress: String): Response<TimeZoneData>

    //endregion
    //==============================================================================================
    //region Conversion

    /**
     * Converts the time in one time zone to the corresponding time in another time zone.
     *
     * @param request A request object containing the source time zone, target time zone, and other parameters.
     * @return A conversion result containing the converted time.
     */
    @POST("/api/conversion/converttimezone")
    suspend fun svPostConvertTimeZone(@Body request: Conversion.ConvertRequest): Response<Conversion.Conversion>

    /**
     * Converts a date-time to a language-translated, friendly date-time string.
     *
     * @param request A request object containing the date-time and language code.
     * @return A translation of the date-time in the specified language.
     */
    @POST("/api/conversion/translate")
    suspend fun svPostTranslate(@Body request: Conversion.TranslationRequest): Response<Conversion.Translation>

    /**
     * Converts a date to the corresponding day of the week.
     *
     * @param date The date in "yyyy-MM-dd" format. Example: "2021-03-14".
     * @return The day of the week for the given date.
     */
    @GET("/api/conversion/dayoftheweek/{date}")
    suspend fun svGetWeekdayOfDate(@Path("date") date: String): Response<Conversion.DayOfTheWeekResult>

    /**
     * Converts a date to the corresponding day of the year.
     *
     * @param date The date in "yyyy-MM-dd" format. Example: "2021-03-14".
     * @return The day of the year for the given date.
     */
    @GET("/api/conversion/dayoftheyear/{date}")
    suspend fun svGetDayOfYear(@Path("date") date: String): Response<Conversion.DayOfYearResponse>
    //endregion
    //==============================================================================================
    //region Calculation

    /**
     * Increments the current date-time by a specified time span.
     *
     * @param request A request object specifying the time span to increment.
     * @return The resulting date-time after incrementing.
     */
    @POST("/api/calculation/current/increment")
    suspend fun svPostIncrementCurrentDateTime(@Body request: Calculation.CurrentRequest): Response<Calculation.Calculation>

    /**
     * Decrements the current date-time by a specified time span.
     *
     * @param request A request object specifying the time span to decrement.
     * @return The resulting date-time after decrementing.
     */
    @POST("/api/calculation/current/decrement")
    suspend fun svPostDecrementCurrentDateTime(@Body request: Calculation.CurrentRequest): Response<Calculation.Calculation>

    /**
     * Increments a custom date-time by a specified time span.
     *
     * @param request A request object containing the custom date-time and time span to increment.
     * @return The resulting custom date-time after incrementing.
     */
    @POST("/api/calculation/custom/increment")
    suspend fun svPostIncrementCustomDateTime(@Body request: Calculation.CustomRequest): Response<Calculation.Calculation>

    /**
     * Decrements a custom date-time by a specified time span.
     *
     * @param request A request object containing the custom date-time and time span to decrement.
     * @return The resulting custom date-time after decrementing.
     */
    @POST("/api/calculation/custom/decrement")
    suspend fun svPostDecrementCustomDateTime(@Body request: Calculation.CustomRequest): Response<Calculation.Calculation>
    //endregion
    //==============================================================================================
    //region Health

    /**
     * Performs a health check of the API.
     *
     * @return A response indicating the health status of the API.
     */
    @GET("/api/health/check")
    suspend fun svGetHealthCheck(): Response<String>
    //endregion
    //==============================================================================================
}