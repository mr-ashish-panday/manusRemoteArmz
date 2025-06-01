package com.remotearmz.commandcenter.util

import java.text.NumberFormat
import java.util.Locale

/**
 * Utility object for currency conversions and formatting.
 */
object CurrencyConverter {

    private const val USD_TO_NPR_RATE = 135.0

    /**
     * Converts USD to NPR using a fixed rate.
     *
     * @param usd The amount in USD.
     * @return The equivalent amount in NPR.
     */
    fun usdToNpr(usd: Double): Double {
        return usd * USD_TO_NPR_RATE
    }

    /**
     * Formats a Double value as a USD currency string.
     *
     * @param value The amount in USD.
     * @return Formatted string (e.g., "$1,234.56").
     */
    fun formatUSD(value: Double): String {
        val format = NumberFormat.getCurrencyInstance(Locale.US)
        return format.format(value)
    }

    /**
     * Formats a Double value as an NPR currency string.
     *
     * @param value The amount in NPR.
     * @return Formatted string (e.g., "NPR 166,717.50").
     */
    fun formatNPR(value: Double): String {
        // Locale for Nepal might not be standard, create custom format
        val format = NumberFormat.getCurrencyInstance(Locale("ne", "NP"))
        // Or use a generic format if Locale doesn't work as expected:
        // val format = NumberFormat.getCurrencyInstance()
        // format.currency = Currency.getInstance("NPR")
        // return format.format(value)
        // Simpler approach if Locale("ne", "NP") isn't reliable:
        val numberFormat = NumberFormat.getNumberInstance(Locale.US) // Use US locale for comma separation
        numberFormat.maximumFractionDigits = 2
        numberFormat.minimumFractionDigits = 2
        return "NPR ${numberFormat.format(value)}"
    }

    // Add nprToUsd if needed
    // fun nprToUsd(npr: Double): Double {
    //     return npr / USD_TO_NPR_RATE
    // }
}

