package com.juacie.viewsonic.app.main.model

import java.time.Instant

/**
 * Represents an offset in time with specific components.
 *
 * @param seconds The number of seconds in the offset.
 * @param milliseconds The number of milliseconds in the offset.
 * @param ticks The number of ticks in the offset.
 * @param nanoseconds The number of nanoseconds in the offset.
 */
data class Offset(
    val seconds: Int,
    val milliseconds: Int,
    val ticks: Int,
    val nanoseconds: Int
)

/**
 * Represents a duration of time with detailed components.
 *
 * @param days Number of days in the duration.
 * @param nanosecondOfDay The number of nanoseconds elapsed in the current day.
 * @param hours The number of hours in the duration.
 * @param minutes The number of minutes in the duration.
 * @param seconds The number of seconds in the duration.
 * @param milliseconds The number of milliseconds in the duration.
 * @param subsecondTicks The number of subsecond ticks in the duration.
 * @param subsecondNanoseconds The number of subsecond nanoseconds in the duration.
 * @param bclCompatibleTicks A field for BCL-compatible ticks.
 * @param totalDays Total number of days in the duration.
 * @param totalHours Total number of hours in the duration.
 * @param totalMinutes Total number of minutes in the duration.
 * @param totalSeconds Total number of seconds in the duration.
 * @param totalMilliseconds Total number of milliseconds in the duration.
 * @param totalTicks Total number of ticks in the duration.
 * @param totalNanoseconds Total number of nanoseconds in the duration.
 */
data class Duration(
    val days: Int,
    val nanosecondOfDay: Int,
    val hours: Int,
    val minutes: Int,
    val seconds: Int,
    val milliseconds: Int,
    val subsecondTicks: Int,
    val subsecondNanoseconds: Int,
    val bclCompatibleTicks: Int,
    val totalDays: Int,
    val totalHours: Int,
    val totalMinutes: Int,
    val totalSeconds: Int,
    val totalMilliseconds: Int,
    val totalTicks: Int,
    val totalNanoseconds: Int
)

/**
 * Represents the daylight saving time (DST) interval.
 *
 * @param dstName The name of the daylight saving time period.
 * @param dstOffsetToUtc The offset from UTC during DST.
 * @param dstOffsetToStandardTime The offset from standard time during DST.
 * @param dstStart The start time of the DST period.
 * @param dstEnd The end time of the DST period.
 * @param dstDuration The total duration of the DST period.
 */
data class DstInterval(
    val dstName: String? = null,
    val dstOffsetToUtc: Offset,
    val dstOffsetToStandardTime: Offset,
    val dstStart: Instant? = null,
    val dstEnd: Instant? = null,
    val dstDuration: Duration
)

/**
 * Represents time zone data with information about the current time, offsets, and DST.
 *
 * @param timeZone The name of the time zone (e.g., "Europe/Amsterdam").
 * @param currentLocalTime The current local time in the time zone.
 * @param currentUtcOffset The current offset from UTC in the time zone.
 * @param standardUtcOffset The standard offset from UTC in the time zone.
 * @param hasDayLightSaving A flag indicating whether the time zone observes daylight saving time (DST).
 * @param isDayLightSavingActive A flag indicating whether DST is currently active in the time zone.
 * @param dstInterval The details of the DST interval if applicable.
 */
data class TimeZoneData(
    val timeZone: String? = null,
    val currentLocalTime: Instant,
    val currentUtcOffset: Offset,
    val standardUtcOffset: Offset,
    val hasDayLightSaving: Boolean,
    val isDayLightSavingActive: Boolean,
    val dstInterval: DstInterval
)