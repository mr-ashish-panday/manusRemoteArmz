package com.remotearmz.commandcenter.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0014\u001a\u00020\fH\'J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/remotearmz/commandcenter/data/dao/ClientDao;", "", "deleteClient", "", "client", "Lcom/remotearmz/commandcenter/data/model/Client;", "(Lcom/remotearmz/commandcenter/data/model/Client;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllClients", "Lkotlinx/coroutines/flow/Flow;", "", "getClientById", "clientId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClientsByStatus", "status", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "insertClient", "", "searchClients", "query", "updateClient", "app_release"})
public abstract interface ClientDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM clients ORDER BY name ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> getAllClients();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM clients WHERE id = :clientId")
    public abstract java.lang.Object getClientById(@org.jetbrains.annotations.NotNull
    java.lang.String clientId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.Client> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM clients WHERE name LIKE \'%\' || :query || \'%\' OR company LIKE \'%\' || :query || \'%\'")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> searchClients(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM clients WHERE status = :status ORDER BY name ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> getClientsByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ClientStatus status);
}