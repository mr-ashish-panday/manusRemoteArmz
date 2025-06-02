package com.remotearmz.commandcenter.ui.clients;

import androidx.lifecycle.ViewModel;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.ui.clients.ClientsScreenState.*;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import java.io.IOException;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\rJ\u0010\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015\u00a8\u0006+"}, d2 = {"Lcom/remotearmz/commandcenter/ui/clients/ClientsViewModel;", "Landroidx/lifecycle/ViewModel;", "clientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "(Lcom/remotearmz/commandcenter/data/repository/ClientRepository;)V", "_clients", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/remotearmz/commandcenter/data/model/Client;", "_editingClient", "_isAddingClient", "", "_searchQuery", "", "_statusFilter", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "_uiState", "Lcom/remotearmz/commandcenter/ui/clients/UiState;", "editingClient", "Lkotlinx/coroutines/flow/StateFlow;", "getEditingClient", "()Lkotlinx/coroutines/flow/StateFlow;", "isAddingClient", "searchQuery", "getSearchQuery", "statusFilter", "getStatusFilter", "uiState", "getUiState", "addClient", "", "client", "deleteClient", "hideAddClientDialog", "hideEditClientDialog", "loadClients", "showAddClientDialog", "showEditClientDialog", "updateClient", "updateSearchQuery", "query", "updateStatusFilter", "status", "app_debug"})
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
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.ui.clients.UiState<java.util.List<com.remotearmz.commandcenter.data.model.Client>>> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.clients.UiState<java.util.List<com.remotearmz.commandcenter.data.model.Client>>> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Client>> _clients = null;
    
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
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.clients.UiState<java.util.List<com.remotearmz.commandcenter.data.model.Client>>> getUiState() {
        return null;
    }
    
    public final void loadClients() {
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