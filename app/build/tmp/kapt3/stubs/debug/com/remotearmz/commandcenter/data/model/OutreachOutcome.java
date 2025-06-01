package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "", "(Ljava/lang/String;I)V", "SUCCESSFUL", "NO_RESPONSE", "INTERESTED", "NOT_INTERESTED", "FOLLOW_UP_NEEDED", "app_debug"})
public enum OutreachOutcome {
    /*public static final*/ SUCCESSFUL /* = new SUCCESSFUL() */,
    /*public static final*/ NO_RESPONSE /* = new NO_RESPONSE() */,
    /*public static final*/ INTERESTED /* = new INTERESTED() */,
    /*public static final*/ NOT_INTERESTED /* = new NOT_INTERESTED() */,
    /*public static final*/ FOLLOW_UP_NEEDED /* = new FOLLOW_UP_NEEDED() */;
    
    OutreachOutcome() {
    }
}