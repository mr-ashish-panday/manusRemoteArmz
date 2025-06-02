package com.remotearmz.commandcenter.backup;

import java.lang.System;

/**
 * Represents the status of a backup or restore operation.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00142\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006\u0082\u0001\u0004\u0019\u001a\u001b\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupStatus;", "", "()V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "isFailed", "", "()Z", "isInProgress", "isSuccess", "progress", "", "getProgress", "()I", "statusMessage", "getStatusMessage", "successMessage", "getSuccessMessage", "Companion", "Failed", "Idle", "InProgress", "Success", "Lcom/remotearmz/commandcenter/backup/BackupStatus$Failed;", "Lcom/remotearmz/commandcenter/backup/BackupStatus$Idle;", "Lcom/remotearmz/commandcenter/backup/BackupStatus$InProgress;", "Lcom/remotearmz/commandcenter/backup/BackupStatus$Success;", "app_release"})
public abstract class BackupStatus {
    @org.jetbrains.annotations.NotNull
    public static final com.remotearmz.commandcenter.backup.BackupStatus.Companion Companion = null;
    
    private BackupStatus() {
        super();
    }
    
    public final boolean isInProgress() {
        return false;
    }
    
    public final boolean isSuccess() {
        return false;
    }
    
    public final boolean isFailed() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSuccessMessage() {
        return null;
    }
    
    public final int getProgress() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStatusMessage() {
        return null;
    }
    
    /**
     * The operation is idle or not started.
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupStatus$Idle;", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "()V", "app_release"})
    public static final class Idle extends com.remotearmz.commandcenter.backup.BackupStatus {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.backup.BackupStatus.Idle INSTANCE = null;
        
        private Idle() {
            super();
        }
    }
    
    /**
     * The operation is in progress.
     * @property message Optional status message
     * @property progress Optional progress value between 0 and 100, or -1 if indeterminate
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupStatus$InProgress;", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "message", "", "progress", "", "(Ljava/lang/String;I)V", "getMessage", "()Ljava/lang/String;", "getProgress", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"})
    public static final class InProgress extends com.remotearmz.commandcenter.backup.BackupStatus {
        @org.jetbrains.annotations.Nullable
        private final java.lang.String message = null;
        private final int progress = 0;
        
        /**
         * The operation is in progress.
         * @property message Optional status message
         * @property progress Optional progress value between 0 and 100, or -1 if indeterminate
         */
        @org.jetbrains.annotations.NotNull
        public final com.remotearmz.commandcenter.backup.BackupStatus.InProgress copy(@org.jetbrains.annotations.Nullable
        java.lang.String message, int progress) {
            return null;
        }
        
        /**
         * The operation is in progress.
         * @property message Optional status message
         * @property progress Optional progress value between 0 and 100, or -1 if indeterminate
         */
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        /**
         * The operation is in progress.
         * @property message Optional status message
         * @property progress Optional progress value between 0 and 100, or -1 if indeterminate
         */
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        /**
         * The operation is in progress.
         * @property message Optional status message
         * @property progress Optional progress value between 0 and 100, or -1 if indeterminate
         */
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public InProgress() {
            super();
        }
        
        public InProgress(@org.jetbrains.annotations.Nullable
        java.lang.String message, int progress) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final int component2() {
            return 0;
        }
        
        @java.lang.Override
        public final int getProgress() {
            return 0;
        }
    }
    
    /**
     * The operation completed successfully.
     * @property message Optional success message
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupStatus$Success;", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"})
    public static final class Success extends com.remotearmz.commandcenter.backup.BackupStatus {
        @org.jetbrains.annotations.Nullable
        private final java.lang.String message = null;
        
        /**
         * The operation completed successfully.
         * @property message Optional success message
         */
        @org.jetbrains.annotations.NotNull
        public final com.remotearmz.commandcenter.backup.BackupStatus.Success copy(@org.jetbrains.annotations.Nullable
        java.lang.String message) {
            return null;
        }
        
        /**
         * The operation completed successfully.
         * @property message Optional success message
         */
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        /**
         * The operation completed successfully.
         * @property message Optional success message
         */
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        /**
         * The operation completed successfully.
         * @property message Optional success message
         */
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public Success() {
            super();
        }
        
        public Success(@org.jetbrains.annotations.Nullable
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getMessage() {
            return null;
        }
    }
    
    /**
     * The operation failed.
     * @property error Error message
     * @property throwable Optional throwable that caused the failure
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupStatus$Failed;", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "error", "", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/String;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"})
    public static final class Failed extends com.remotearmz.commandcenter.backup.BackupStatus {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String error = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.Throwable throwable = null;
        
        /**
         * The operation failed.
         * @property error Error message
         * @property throwable Optional throwable that caused the failure
         */
        @org.jetbrains.annotations.NotNull
        public final com.remotearmz.commandcenter.backup.BackupStatus.Failed copy(@org.jetbrains.annotations.NotNull
        java.lang.String error, @org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable) {
            return null;
        }
        
        /**
         * The operation failed.
         * @property error Error message
         * @property throwable Optional throwable that caused the failure
         */
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        /**
         * The operation failed.
         * @property error Error message
         * @property throwable Optional throwable that caused the failure
         */
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        /**
         * The operation failed.
         * @property error Error message
         * @property throwable Optional throwable that caused the failure
         */
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public Failed(@org.jetbrains.annotations.NotNull
        java.lang.String error, @org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getError() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable getThrowable() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001c\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupStatus$Companion;", "", "()V", "failed", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "error", "", "throwable", "", "inProgress", "message", "progress", "", "success", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Create a new in-progress status with the given message and progress.
         */
        @org.jetbrains.annotations.NotNull
        public final com.remotearmz.commandcenter.backup.BackupStatus inProgress(@org.jetbrains.annotations.Nullable
        java.lang.String message, int progress) {
            return null;
        }
        
        /**
         * Create a new success status with the given message.
         */
        @org.jetbrains.annotations.NotNull
        public final com.remotearmz.commandcenter.backup.BackupStatus success(@org.jetbrains.annotations.Nullable
        java.lang.String message) {
            return null;
        }
        
        /**
         * Create a new failed status with the given error message and optional throwable.
         */
        @org.jetbrains.annotations.NotNull
        public final com.remotearmz.commandcenter.backup.BackupStatus failed(@org.jetbrains.annotations.NotNull
        java.lang.String error, @org.jetbrains.annotations.Nullable
        java.lang.Throwable throwable) {
            return null;
        }
    }
}