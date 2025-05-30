package com.remotearmz.commandcenter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.remotearmz.commandcenter.utils.CurrencyConverter
import java.util.UUID

@Entity(tableName = "clients")
data class Client(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val company: String,
    val phone: String,
    val email: String,
    val contractValueUSD: Double = 0.0,
    val status: ClientStatus = ClientStatus.ACTIVE,
    val tags: List<String> = emptyList(),
    val notes: String = "",
    val lastContactDate: Long? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    val contractValueNPR: Double
        get() = CurrencyConverter.usdToNpr(contractValueUSD)
    
    // Calculate days since last contact
    val daysSinceLastContact: Int?
        get() {
            if (lastContactDate == null) return null
            val now = System.currentTimeMillis()
            val millisPerDay = 24 * 60 * 60 * 1000
            return ((now - lastContactDate) / millisPerDay).toInt()
        }
}

enum class ClientStatus { ACTIVE, INACTIVE, PROSPECT }
