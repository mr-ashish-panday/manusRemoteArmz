package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.remotearmz.commandcenter.utils.CurrencyConverter;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "", "(Ljava/lang/String;I)V", "NEW", "CONTACTED", "QUALIFIED", "PROPOSAL", "NEGOTIATION", "WON", "LOST", "app_debug"})
public enum LeadStatus {
    /*public static final*/ NEW /* = new NEW() */,
    /*public static final*/ CONTACTED /* = new CONTACTED() */,
    /*public static final*/ QUALIFIED /* = new QUALIFIED() */,
    /*public static final*/ PROPOSAL /* = new PROPOSAL() */,
    /*public static final*/ NEGOTIATION /* = new NEGOTIATION() */,
    /*public static final*/ WON /* = new WON() */,
    /*public static final*/ LOST /* = new LOST() */;
    
    LeadStatus() {
    }
}