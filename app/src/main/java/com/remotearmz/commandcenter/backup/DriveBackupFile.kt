package com.remotearmz.commandcenter.backup

/**
 * Represents a backup file stored in Google Drive.
 *
 * @property id The unique identifier of the file in Google Drive.
 * @property name The name of the backup file.
 * @property size The size of the file in bytes.
 * @property modifiedTime The timestamp when the file was last modified.
 * @property mimeType The MIME type of the file.
 */
data class DriveBackupFile(
    val id: String,
    val name: String,
    val size: Long,
    val modifiedTime: Long,
    val mimeType: String = "application/json"
) {
    /**
     * Get a formatted string representing the file size in a human-readable format.
     */
    fun getFormattedSize(): String {
        return when {
            size < 1024 -> "$size B"
            size < 1024 * 1024 -> "${String.format("%.1f", size / 1024.0)} KB"
            size < 1024 * 1024 * 1024 -> "${String.format("%.1f", size / (1024.0 * 1024.0))} MB"
            else -> "${String.format("%.2f", size / (1024.0 * 1024.0 * 1024.0))} GB"
        }
    }

    /**
     * Get a formatted string representing the last modified time.
     */
    fun getFormattedModifiedTime(format: String = "MMM dd, yyyy 'at' hh:mm a"): String {
        return java.text.SimpleDateFormat(format, java.util.Locale.getDefault())
            .format(java.util.Date(modifiedTime))
    }
}
