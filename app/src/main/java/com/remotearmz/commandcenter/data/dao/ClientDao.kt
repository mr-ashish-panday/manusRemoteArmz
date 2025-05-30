package com.remotearmz.commandcenter.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(client: Client): Long
    
    @Update
    suspend fun updateClient(client: Client)
    
    @Delete
    suspend fun deleteClient(client: Client)
    
    @Query("SELECT * FROM clients ORDER BY name ASC")
    fun getAllClients(): Flow<List<Client>>
    
    @Query("SELECT * FROM clients WHERE id = :clientId")
    suspend fun getClientById(clientId: String): Client?
    
    @Query("SELECT * FROM clients WHERE name LIKE '%' || :query || '%' OR company LIKE '%' || :query || '%'")
    fun searchClients(query: String): Flow<List<Client>>
    
    @Query("SELECT * FROM clients WHERE status = :status ORDER BY name ASC")
    fun getClientsByStatus(status: ClientStatus): Flow<List<Client>>
}
