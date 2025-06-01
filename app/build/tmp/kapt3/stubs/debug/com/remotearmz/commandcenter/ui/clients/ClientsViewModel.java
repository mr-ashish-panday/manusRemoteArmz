package com.remotearmz.commandcenter.ui.clients;

import androidx.lifecycle.ViewModel;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000bJ\u0010\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\rR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012\u00a8\u0006\'"}, d2 = {"Lcom/remotearmz/commandcenter/ui/clients/ClientsViewModel;", "Landroidx/lifecycle/ViewModel;", "clientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "(Lcom/remotearmz/commandcenter/data/repository/ClientRepository;)V", "_editingClient", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/remotearmz/commandcenter/data/model/Client;", "_isAddingClient", "", "_searchQuery", "", "_statusFilter", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "clients", "Lkotlinx/coroutines/flow/StateFlow;", "", "getClients", "()Lkotlinx/coroutines/flow/StateFlow;", "editingClient", "getEditingClient", "isAddingClient", "searchQuery", "getSearchQuery", "statusFilter", "getStatusFilter", "addClient", "", "client", "deleteClient", "hideAddClientDialog", "hideEditClientDialog", "showAddClientDialog", "showEditClientDialog", "updateClient", "updateSearchQuery", "query", "updateStatusFilter", "status", "app_debug"})
public final class ClientsViewModel extends androidx.lifecycle.ViewModel {
    private final com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.ClientStatus> _statusFilter = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.data.model.ClientStatus> statusFilter = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isAddingClient = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isAddingClient = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.Client> _editingClient = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.data.model.Client> editingClient = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> clients = null;
    
    @javax.inject.Inject
    public ClientsViewModel(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.data.model.ClientStatus> getStatusFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isAddingClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.data.model.Client> getEditingClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> getClients() {
        return null;
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void updateStatusFilter(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.ClientStatus status) {
    }
    
    public final void showAddClientDialog() {
    }
    
    public final void hideAddClientDialog() {
    }
    
    public final void showEditClientDialog(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client) {
    }
    
    public final void hideEditClientDialog() {
    }
    
    public final void addClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client) {
    }
    
    public final void updateClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client) {
    }
    
    public final void deleteClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client) {
    }
}