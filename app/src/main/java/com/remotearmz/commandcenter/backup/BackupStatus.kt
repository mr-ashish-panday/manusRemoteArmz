package com.remotearmz.commandcenter.backup

/**
 * Represents the status of a backup or restore operation.
 */
sealed class BackupStatus {
    /**
     * The operation is idle or not started.
     */
    object Idle : BackupStatus()

    /**
     * The operation is in progress.
     * @property message Optional status message
     * @property progress Optional progress value between 0 and 100, or -1 if indeterminate
     */
    data class InProgress(
        val message: String? = null,
        val progress: Int = -1
    ) : BackupStatus()

    /**
     * The operation completed successfully.
     * @property message Optional success message
     */
    data class Success(
        val message: String? = null
    ) : BackupStatus()

    /**
     * The operation failed.
     * @property error Error message
     * @property throwable Optional throwable that caused the failure
     */
    data class Failed(
        val error: String,
        val throwable: Throwable? = null
    ) : BackupStatus()

    /**
     * Check if the operation is in progress.
     */
    val isInProgress: Boolean
        get() = this is InProgress

    /**
     * Check if the operation completed successfully.
     */
    val isSuccess: Boolean
        get() = this is Success

    /**
     * Check if the operation failed.
     */
    val isFailed: Boolean
        get() = this is Failed

    /**
     * Get the error message if the operation failed.
     */
    val errorMessage: String?
        get() = (this as? Failed)?.error

    /**
     * Get the success message if the operation succeeded.
     */
    val successMessage: String?
        get() = (this as? Success)?.message

    /**
     * Get the progress if the operation is in progress.
     */
    val progress: Int
        get() = (this as? InProgress)?.progress ?: -1

    /**
     * Get the current status message.
     */
    val statusMessage: String?
        get() = when (this) {
            is InProgress -> message ?: "In progress..."
            is Success -> message ?: "Operation completed successfully"
            is Failed -> error
            else -> null
        }

    companion object {
        /**
         * Create a new in-progress status with the given message and progress.
         */
        fun inProgress(message: String? = null, progress: Int = -1): BackupStatus {
            return InProgress(message, progress)
        }

        /**
         * Create a new success status with the given message.
         */
        fun success(message: String? = null): BackupStatus {
            return Success(message)
        }

        /**
         * Create a new failed status with the given error message and optional throwable.
         */
        fun failed(error: String, throwable: Throwable? = null): BackupStatus {
            return Failed(error, throwable)
        }
    }
}
