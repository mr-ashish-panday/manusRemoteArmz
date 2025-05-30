package com.remotearmz.commandcenter.data.model

import androidx.room.ColumnInfo

data class TypeCount(
    @ColumnInfo(name = "type")
    val type: OutreachType,
    
    @ColumnInfo(name = "count")
    val count: Int
)
