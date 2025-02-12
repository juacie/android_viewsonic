package com.juacie.viewsonic.data.model

/**
 * Represents a standardized error response format, commonly used in APIs.
 *
 * @param type A URI reference that identifies the problem type. Typically used for documentation.
 * @param title A short, human-readable summary of the problem.
 * @param status The HTTP status code associated with this problem.
 * @param detail A detailed explanation of the specific error.
 * @param instance A URI reference that identifies the specific occurrence of the problem.
 * @param additionalProperties A map of additional properties that may provide more context about the error.
 */
data class ProblemDetails(
    val type: String? = null,
    val title: String? = null,
    val status: Int? = null,
    val detail: String? = null,
    val instance: String? = null,
    val additionalProperties: Map<String, String> = emptyMap()
)