package com.remotearmz.commandcenter.util

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

object CurrencyFormatter {
    
    fun formatUSD(amount: Double): String {
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        format.currency = Currency.getInstance("USD")
        return format.format(amount)
    }
    
    fun formatNPR(amount: Double): String {
        val format = NumberFormat.getCurrencyInstance(Locale("ne", "NP"))
        format.currency = Currency.getInstance("NPR")
        return format.format(amount)
    }
    
    fun formatWithSymbol(amount: Double, currencyCode: String): String {
        val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
        format.currency = Currency.getInstance(currencyCode)
        return format.format(amount)
    }
    
    fun formatWithoutSymbol(amount: Double): String {
        val format = NumberFormat.getNumberInstance(Locale.getDefault())
        format.minimumFractionDigits = 2
        format.maximumFractionDigits = 2
        return format.format(amount)
    }
}
