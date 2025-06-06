package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/OutreachType;", "", "(Ljava/lang/String;I)V", "CALL", "EMAIL", "MEETING", "SOCIAL_MEDIA", "app_debug"})
public enum OutreachType {
    /*public static final*/ CALL /* = new CALL() */,
    /*public static final*/ EMAIL /* = new EMAIL() */,
    /*public static final*/ MEETING /* = new MEETING() */,
    /*public static final*/ SOCIAL_MEDIA /* = new SOCIAL_MEDIA() */;
    
    OutreachType() {
    }
}