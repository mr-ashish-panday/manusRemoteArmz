package com.remotearmz.commandcenter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.remotearmz.commandcenter.utils.CurrencyConverter
import java.util.UUID

@Entity(tableName = "leads")
data class Lead(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val contactName: String,
    val company: String,
    val phone: String,
    val email: String,
    val status: LeadStatus = LeadStatus.NEW,
    val valueUSD: Double = 0.0,
    val probability: Int = 0, // 0-100%
    val source: String = "",
    val expectedCloseDate: Long? = null,
    val clientId: String? = null, // Link to client if converted
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    val valueNPR: Double get() = CurrencyConverter.usdToNpr(valueUSD)
    val weightedValueUSD: Double get() = valueUSD * (probability / 100.0)
    val weightedValueNPR: Double get() = CurrencyConverter.usdToNpr(weightedValueUSD)
}

enum class LeadStatus { NEW, CONTACTED, QUALIFIED, PROPOSAL, NEGOTIATION, WON, LOST }
