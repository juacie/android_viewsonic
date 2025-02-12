package com.juacie.viewsonic.data.model

/**
 * Represents detailed date and time information, including timezone and DST status.
 *
 * @param year The year component of the date.
 * @param month The month component (1-12).
 * @param day The day component (1-31).
 * @param hour The hour of the day (0-23).
 * @param minute The minute of the hour (0-59).
 * @param seconds The second of the minute (0-59).
 * @param milliSeconds The millisecond component (0-999).
 * @param dateTime The full date-time in ISO format.
 * Example: `"2021-12-13T09:30:17"`
 * @param date The formatted date string.
 * Example: `"13/12/2021"`
 * @param time The formatted time string.
 * Example: `"09:30"`
 * @param timeZone The IANA timezone identifier.
 * Example: `"Europe/Amsterdam"`
 * @param dayOfWeek The name of the day of the week.
 * See [java.time.DayOfWeek] for possible values.
 * @param dstActive Indicates whether daylight saving time (DST) is active.
 */
data class DateTimeInfo(
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int,
    val minute: Int,
    val seconds: Int,
    val milliSeconds: Int,
    val dateTime: String,
    val date: String,
    val time: String,
    val timeZone: String,
    val dayOfWeek: String,
    val dstActive: Boolean
)