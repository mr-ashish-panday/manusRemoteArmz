package com.remotearmz.commandcenter.utils

object CurrencyConverter {
    const val USD_TO_NPR_RATE = 135.0
    
    fun usdToNpr(usd: Double): Double = usd * USD_TO_NPR_RATE
    
    fun formatNPR(amount: Double): String {
        return "NPR ${String.format("%,.0f", amount)}"
    }
    
    fun formatUSD(amount: Double): String {
        return "$${String.format("%.2f", amount)}"
    }
}
