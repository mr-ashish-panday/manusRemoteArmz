package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.remotearmz.commandcenter.utils.CurrencyConverter;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "", "(Ljava/lang/String;I)V", "ACTIVE", "INACTIVE", "PROSPECT", "app_release"})
public enum ClientStatus {
    /*public static final*/ ACTIVE /* = new ACTIVE() */,
    /*public static final*/ INACTIVE /* = new INACTIVE() */,
    /*public static final*/ PROSPECT /* = new PROSPECT() */;
    
    ClientStatus() {
    }
}