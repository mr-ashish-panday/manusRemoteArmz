package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.ClientDao
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ClientRepository @Inject constructor(
    private val clientDao: ClientDao
) {
    fun getAllClients(): Flow<Result<List<Client>>> = flow {
        try {
            clientDao.getAllClients()
                .catch { e ->
                    emit(Result.failure(e))
                }
                .collect { clients ->
                    emit(Result.success(clients))
                }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    fun searchClients(query: String): Flow<Result<List<Client>>> = flow {
        try {
            clientDao.searchClients(query)
                .catch { e ->
                    emit(Result.failure(e))
                }
                .collect { clients ->
                    emit(Result.success(clients))
                }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    fun getClientsByStatus(status: ClientStatus): Flow<Result<List<Client>>> = flow {
        try {
            clientDao.getClientsByStatus(status)
                .catch { e ->
                    emit(Result.failure(e))
                }
                .collect { clients ->
                    emit(Result.success(clients))
                }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    suspend fun getClientById(id: String): Result<Client> = try {
        val client = clientDao.getClientById(id)
        if (client != null) {
            Result.success(client)
        } else {
            Result.failure(NoSuchElementException("Client not found with id: $id"))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
    
    suspend fun insertClient(client: Client): Result<Long> = try {
        val id = clientDao.insertClient(client)
        Result.success(id)
    } catch (e: Exception) {
        Result.failure(e)
    }
    
    suspend fun updateClient(client: Client): Result<Unit> = try {
        clientDao.updateClient(client)
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }
    
    suspend fun deleteClient(client: Client): Result<Unit> = try {
        clientDao.deleteClient(client)
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }
}
