package com.juacie.viewsonic.app.main.model

import java.time.Instant
import java.time.LocalDateTime

class Conversion {
    //----------------------------------------------------------------------------------------------
    //region Convert Time Zone

    /**
     * Represents a request to convert a datetime from one timezone to another.
     *
     * @param fromTimeZone IANA time zone identifier.
     * Example: `"Europe/Amsterdam"`
     * @param dateTime The datetime to convert, in either of the following formats:
     * - `yyyy-MM-dd HH:mm:ss`
     * - `yyyy-MM-dd HH:mm:ss.ffffff`
     * Example: `"2021-11-27 05:45:00"`
     * @param toTimeZone IANA time zone identifier for the target timezone.
     * Example: `"America/Los_Angeles"`
     * @param dstAmbiguity Handles ambiguous times due to daylight saving time (DST) changes.
     * If a time appears twice (e.g., when clocks go backward at 2 AM):
     * - `"earlier"` selects the first occurrence.
     * - `"later"` selects the second occurrence.
     */
    data class ConvertRequest(
        val fromTimeZone: String,
        val dateTime: LocalDateTime,
        val toTimeZone: String,
        val dstAmbiguity: String? = null
    )

    /**
     * Represents the result of a timezone conversion.
     *
     * @param year The year component of the converted date.
     * @param month The month component (1-12).
     * @param day The day component (1-31).
     * @param hour The hour component (0-23).
     * @param minute The minute component (0-59).
     * @param seconds The second component (0-59).
     * @param milliSeconds The millisecond component (0-999).
     * @param dateTime The full converted datetime in ISO format.
     * Example: `"2021-12-13T09:30:17"`
     * @param date The formatted date string.
     * Example: `"13/12/2021"`
     * @param time The formatted time string.
     * Example: `"09:30"`
     * @param timeZone The final timezone after conversion.
     * Example: `"America/Los_Angeles"`
     * @param dstActive Indicates whether daylight saving time (DST) is active.
     */
    data class ConversionResult(
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
        val timeZone: String? = null,
        val dstActive: Boolean
    )

    /**
     * Represents the final output of a time zone conversion.
     *
     * @param fromTimezone The original timezone before conversion.
     * Example: `"Europe/Amsterdam"`
     * @param fromDateTime The original datetime before conversion, in UTC format.
     * @param toTimeZone The target timezone after conversion.
     * Example: `"America/Los_Angeles"`
     * @param conversionResult The computed result after conversion.
     */
    data class Conversion(
        val fromTimezone: String? = null,
        val fromDateTime: Instant,
        val toTimeZone: String? = null,
        val conversionResult: ConversionResult
    )

    //endregion
    //----------------------------------------------------------------------------------------------
    //region Translation

    /**
     * Represents a request to translate a datetime into a specific language.
     *
     * @param dateTime The datetime to be translated, in the format:
     * - `yyyy-MM-dd HH:mm:ss`
     * - `yyyy-MM-dd HH:mm:ss.ffffff`
     * Example: `"2021-03-14 17:45:00"`
     * @param languageCode A 2-letter ISO 639-1 language code.
     * Full list of codes: [ISO 639-1 Codes](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes)
     * Example: `"de"`
     */
    data class TranslationRequest(
        val dateTime: String,
        val languageCode: String
    )

    /**
     * Represents the translated representation of a datetime.
     *
     * @param dateTime The original datetime provided for translation.
     * Example: `"2021-03-14 17:45:00"`
     * @param languageCode The language code used for translation.
     * Example: `"de"`
     * @param friendlyDateTime The fully translated datetime string.
     * Example: `"Sonntag, 14. März 2021 17:45:00"`
     * @param friendlyDate The translated date portion.
     * Example: `"Sonntag, 14. März 2021"`
     * @param friendlyTime The translated time portion.
     * Example: `"17:45:00"`
     */
    data class Translation(
        val dateTime: String? = null,
        val languageCode: String? = null,
        val friendlyDateTime: String? = null,
        val friendlyDate: String? = null,
        val friendlyTime: String? = null
    )

    //endregion
    //----------------------------------------------------------------------------------------------
    //region Date-Based Responses

    /**
     * Represents the name of the day of the week.
     *
     * See [java.time.DayOfWeek] for possible values.
     */
    data class DayOfTheWeekResult(
        val dayOfWeek: String
    )

    /**
     * Represents the day of the year.
     *
     * @param day The numerical day of the year (1-366).
     */
    data class DayOfYearResponse(
        val day: Int
    )

    //endregion
    //----------------------------------------------------------------------------------------------
}