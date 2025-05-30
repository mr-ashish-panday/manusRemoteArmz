package com.remotearmz.commandcenter.data.model

import androidx.room.ColumnInfo

data class OutcomeCount(
    @ColumnInfo(name = "outcome")
    val outcome: OutreachOutcome,
    
    @ColumnInfo(name = "count")
    val count: Int
)
