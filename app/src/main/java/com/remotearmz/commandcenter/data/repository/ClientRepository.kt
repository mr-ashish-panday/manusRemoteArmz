package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.ClientDao
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class ClientRepository @Inject constructor(
    private val clientDao: ClientDao
) {
    fun getAllClients(): Flow<List<Client>> = clientDao.getAllClients()
    
    fun searchClients(query: String): Flow<List<Client>> = clientDao.searchClients(query)
    
    fun getClientsByStatus(status: ClientStatus): Flow<List<Client>> = clientDao.getClientsByStatus(status)
    
    suspend fun getClientById(id: String): Client? = clientDao.getClientById(id)
    
    suspend fun insertClient(client: Client): Long = clientDao.insertClient(client)
    
    suspend fun updateClient(client: Client) = clientDao.updateClient(client)
    
    suspend fun deleteClient(client: Client) = clientDao.deleteClient(client)
}
