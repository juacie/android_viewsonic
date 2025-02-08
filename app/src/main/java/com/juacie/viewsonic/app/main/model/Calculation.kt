package com.juacie.viewsonic.app.main.model

import java.time.LocalDateTime

class Calculation {

    /**
     * Represents a request to adjust a given datetime by a specified time span.
     *
     * @param timeZone IANA time zone identifier.
     * Example: `"Europe/Amsterdam"`
     * @param dateTime Date and time in either of the following formats:
     * - `yyyy-MM-dd HH:mm:ss`
     * - `yyyy-MM-dd HH:mm:ss.ffffff`
     * Example: `"2021-11-27 05:45:00"`
     * @param timeSpan Time span to modify the datetime, formatted as:
     * - `d:hh:mm:ss`
     * - `d:hh:mm:ss.fff`
     * Example: `"16:03:45:17"` (16 days, 3 hours, 45 minutes, 17 seconds)
     * @param dstAmbiguity Resolves ambiguity caused by daylight saving time (DST) transitions.
     * If a time appears twice (e.g., when clocks go backward at 2 AM),
     * - `"earlier"` selects the first occurrence.
     * - `"later"` selects the second occurrence.
     */
    data class CustomRequest(
        val timeZone: String,
        val dateTime: String,
        val timeSpan: String,
        val dstAmbiguity: String? = null
    )

    /**
     * Represents a request to adjust the current time by a specified time span.
     *
     * @param timeZone IANA time zone identifier.
     * Example: `"Europe/Amsterdam"`
     * @param timeSpan Time span to modify the datetime, formatted as:
     * - `d:hh:mm:ss`
     * - `d:hh:mm:ss.fff`
     * Example: `"16:03:45:17"`
     */
    data class CurrentRequest(
        val timeZone: String,
        val timeSpan: String
    )

    /**
     * Represents the result of a datetime calculation.
     *
     * @param year The year component of the calculated date.
     * @param month The month component of the calculated date (1-12).
     * @param day The day component of the calculated date (1-31).
     * @param hour The hour component of the calculated time (0-23).
     * @param minute The minute component of the calculated time (0-59).
     * @param seconds The second component of the calculated time (0-59).
     * @param milliSeconds The millisecond component of the calculated time (0-999).
     * @param dateTime The full calculated datetime in ISO format.
     * Example: `"2021-12-13T09:30:17"`
     * @param date The formatted date string.
     * Example: `"13/12/2021"`
     * @param time The formatted time string.
     * Example: `"09:30"`
     * @param dstActive Indicates whether daylight saving time (DST) is active.
     */
    data class CalculationResult(
        val year: Int,
        val month: Int,
        val day: Int,
        val hour: Int,
        val minute: Int,
        val seconds: Int,
        val milliSeconds: Int,
        val dateTime: LocalDateTime,
        val date: String? = null,
        val time: String? = null,
        val dstActive: Boolean
    )

    /**
     * Represents the final output of a time calculation.
     *
     * @param timeZone IANA time zone identifier used for the calculation.
     * Example: `"Europe/Amsterdam"`
     * @param originalDateTime The original datetime before modification.
     * Example: `"2021-11-27T05:45:00"`
     * @param usedTimeSpan The time span applied to modify the datetime.
     * Format: `d:hh:mm:ss` (days:hours:minutes:seconds).
     * Example: `"16:03:45:17"`
     * @param calculationResult The computed result after applying the time span.
     */
    data class Calculation(
        val timeZone: String? = null,
        val originalDateTime: LocalDateTime,
        val usedTimeSpan: String? = null,
        val calculationResult: CalculationResult
    )
}