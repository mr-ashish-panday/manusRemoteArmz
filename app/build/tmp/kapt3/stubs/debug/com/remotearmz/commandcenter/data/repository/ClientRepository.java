package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import kotlinx.coroutines.flow.Flow;
import timber.log.Timber;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00060\r\u00f8\u0001\u0002J*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00060\r2\u0006\u0010\u0015\u001a\u00020\u0016\u00f8\u0001\u0002J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0019\u0010\u000bJ#\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00060\r2\u0006\u0010\u001b\u001a\u00020\u0011\u00f8\u0001\u0002J*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u001d\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "", "clientDao", "Lcom/remotearmz/commandcenter/data/dao/ClientDao;", "(Lcom/remotearmz/commandcenter/data/dao/ClientDao;)V", "deleteClient", "Lkotlin/Result;", "", "client", "Lcom/remotearmz/commandcenter/data/model/Client;", "deleteClient-gIAlu-s", "(Lcom/remotearmz/commandcenter/data/model/Client;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllClients", "Lkotlinx/coroutines/flow/Flow;", "", "getClientById", "id", "", "getClientById-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClientsByStatus", "status", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "insertClient", "", "insertClient-gIAlu-s", "searchClients", "query", "updateClient", "updateClient-gIAlu-s", "app_debug"})
@javax.inject.Singleton
public class ClientRepository {
    private final com.remotearmz.commandcenter.data.dao.ClientDao clientDao = null;
    
    @javax.inject.Inject
    public ClientRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.ClientDao clientDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.remotearmz.commandcenter.data.model.Client>>> getAllClients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.remotearmz.commandcenter.data.model.Client>>> searchClients(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.remotearmz.commandcenter.data.model.Client>>> getClientsByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ClientStatus status) {
        return null;
    }
}