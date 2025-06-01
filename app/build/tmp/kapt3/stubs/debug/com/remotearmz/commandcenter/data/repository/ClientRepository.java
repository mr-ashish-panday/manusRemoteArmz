package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0017\u001a\u00020\u000fJ\u0019\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "", "clientDao", "Lcom/remotearmz/commandcenter/data/dao/ClientDao;", "(Lcom/remotearmz/commandcenter/data/dao/ClientDao;)V", "deleteClient", "", "client", "Lcom/remotearmz/commandcenter/data/model/Client;", "(Lcom/remotearmz/commandcenter/data/model/Client;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllClients", "Lkotlinx/coroutines/flow/Flow;", "", "getClientById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClientsByStatus", "status", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "insertClient", "", "searchClients", "query", "updateClient", "app_debug"})
@javax.inject.Singleton
public class ClientRepository {
    private final com.remotearmz.commandcenter.data.dao.ClientDao clientDao = null;
    
    @javax.inject.Inject
    public ClientRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.ClientDao clientDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> getAllClients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> searchClients(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> getClientsByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ClientStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getClientById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.Client> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}