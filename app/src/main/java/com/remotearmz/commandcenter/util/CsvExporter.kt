package com.remotearmz.commandcenter.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.documentfile.provider.DocumentFile
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.Target
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Utility class for exporting app data to CSV format
 */
class CsvExporter(private val context: Context) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    /**
     * Export clients to CSV file
     */
    suspend fun exportClients(clients: List<Client>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                BufferedWriter(OutputStreamWriter(outputStream)).use { writer ->
                    // Write header
                    writer.write("ID,Name,Company,Phone,Email,Contract Value (USD),Contract Value (NPR),Status,Tags,Notes,Last Contact Date,Created At,Updated At\n")

                    // Write data
                    clients.forEach { client ->
                        val row = listOf(
                            client.id,
                            escapeCsvField(client.name),
                            escapeCsvField(client.company ?: ""), // Null safety
                            escapeCsvField(client.phone ?: ""), // Null safety
                            escapeCsvField(client.email ?: ""), // Null safety
                            client.contractValueUSD ?: 0.0, // Null safety
                            client.contractValueNPR ?: 0.0, // Null safety
                            client.status.name, // TODO: Consider ClientStatus.ACTIVE comparison if enum exists
                            escapeCsvField(client.tags?.joinToString("|") ?: ""), // Null safety
                            escapeCsvField(client.notes ?: ""), // Null safety
                            client.lastContactDate?.let { dateFormat.format(Date(it)) } ?: "",
                            dateFormat.format(Date(client.createdAt)),
                            dateFormat.format(Date(client.updatedAt))
                        ).joinToString(",")

                        writer.write("$row\n")
                    }
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            // Log error appropriately
            false
        }
    }

    /**
     * Export leads to CSV file
     */
    suspend fun exportLeads(leads: List<Lead>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                BufferedWriter(OutputStreamWriter(outputStream)).use { writer ->
                    // Write header
                    writer.write("ID,Contact Name,Company,Phone,Email,Status,Value (USD),Value (NPR),Probability,Weighted Value (USD),Weighted Value (NPR),Source,Expected Close Date,Client ID,Created At,Updated At\n")

                    // Write data
                    leads.forEach { lead ->
                        val row = listOf(
                            lead.id,
                            escapeCsvField(lead.contactName),
                            escapeCsvField(lead.company ?: ""), // Null safety
                            escapeCsvField(lead.phone ?: ""), // Null safety
                            escapeCsvField(lead.email ?: ""), // Null safety
                            lead.status.name, // TODO: Consider LeadStatus.NEW comparison if enum exists
                            lead.valueUSD ?: 0.0, // Null safety
                            lead.valueNPR ?: 0.0, // Null safety
                            lead.probability ?: 0.0, // Null safety
                            lead.weightedValueUSD ?: 0.0, // Null safety
                            lead.weightedValueNPR ?: 0.0, // Null safety
                            escapeCsvField(lead.source ?: ""), // Null safety
                            lead.expectedCloseDate?.let { dateFormat.format(Date(it)) } ?: "",
                            lead.clientId ?: "",
                            dateFormat.format(Date(lead.createdAt)),
                            dateFormat.format(Date(lead.updatedAt))
                        ).joinToString(",")

                        writer.write("$row\n")
                    }
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            // Log error appropriately
            false
        }
    }

    /**
     * Export targets to CSV file
     */
    suspend fun exportTargets(targets: List<Target>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                BufferedWriter(OutputStreamWriter(outputStream)).use { writer ->
                    // Write header
                    writer.write("ID,Title,Category,Target Value,Current Value,Progress %,Deadline,Days Remaining,Description,Priority,Completed,Created At\n")

                    // Write data
                    targets.forEach { target ->
                        val row = listOf(
                            target.id,
                            escapeCsvField(target.title),
                            target.category.name, // TODO: Consider TargetCategory.REVENUE comparison if enum exists
                            target.targetValue ?: 0.0, // Null safety
                            target.currentValue ?: 0.0, // Null safety
                            target.progressPercentage ?: 0.0, // Null safety
                            target.deadline?.let { dateFormat.format(Date(it)) } ?: "", // Null safety
                            target.remainingDays ?: 0, // Null safety
                            escapeCsvField(target.description ?: ""), // Null safety
                            target.priority.name, // TODO: Consider TargetPriority.HIGH comparison if enum exists
                            target.isCompleted,
                            target.createdAt?.let { dateFormat.format(Date(it)) } ?: "" // Null safety
                        ).joinToString(",")

                        writer.write("$row\n")
                    }
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            // Log error appropriately
            false
        }
    }

    /**
     * Export outreach activities to CSV file
     */
    suspend fun exportOutreachActivities(activities: List<OutreachActivity>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                BufferedWriter(OutputStreamWriter(outputStream)).use { writer ->
                    // Write header
                    writer.write("ID,Type,Contact ID,Contact Type,Outcome,Notes,Duration (minutes),Follow-up Required,Follow-up Date,Created At\n")

                    // Write data
                    activities.forEach { activity ->
                        val row = listOf(
                            activity.id,
                            activity.type.name, // TODO: Consider OutreachType.CALL comparison if enum exists
                            activity.contactId ?: "", // Null safety
                            activity.contactType.name, // TODO: Consider ContactType.LEAD comparison if enum exists
                            activity.outcome.name, // TODO: Consider OutreachOutcome.SUCCESSFUL comparison if enum exists
                            escapeCsvField(activity.notes ?: ""), // Null safety
                            activity.duration ?: 0, // Null safety
                            activity.followUpRequired,
                            activity.followUpDate?.let { dateFormat.format(Date(it)) } ?: "",
                            activity.createdAt?.let { dateFormat.format(Date(it)) } ?: "" // Null safety
                        ).joinToString(",")

                        writer.write("$row\n")
                    }
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            // Log error appropriately
            false
        }
    }

    /**
     * Export analytics data to CSV file
     */
    suspend fun exportAnalytics(
        clients: List<Client>,
        leads: List<Lead>,
        targets: List<Target>,
        outreachActivities: List<OutreachActivity>,
        uri: Uri
    ): Boolean = withContext(Dispatchers.IO) {
        try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                BufferedWriter(OutputStreamWriter(outputStream)).use { writer ->
                    // Write report header
                    writer.write("REMOTEARMZ COMMAND CENTER - ANALYTICS REPORT\n")
                    writer.write("Generated: ${dateFormat.format(Date())}\n\n")

                    // Client statistics
                    writer.write("CLIENT STATISTICS\n")
                    writer.write("Total Clients,${clients.size}\n")
                    // TODO: Replace string comparisons with enum comparisons if enums exist (e.g., ClientStatus.ACTIVE)
                    writer.write("Active Clients,${clients.count { it.status.name == "ACTIVE" }}\n")
                    writer.write("Inactive Clients,${clients.count { it.status.name == "INACTIVE" }}\n")
                    writer.write("Prospect Clients,${clients.count { it.status.name == "PROSPECT" }}\n")
                    writer.write("Total Contract Value (USD),${clients.sumOf { it.contractValueUSD ?: 0.0 }}\n") // Null safety
                    writer.write("Total Contract Value (NPR),${clients.sumOf { it.contractValueNPR ?: 0.0 }}\n\n") // Null safety

                    // Lead statistics
                    writer.write("LEAD STATISTICS\n")
                    writer.write("Total Leads,${leads.size}\n")
                    // TODO: Replace string comparisons with enum comparisons if enums exist (e.g., LeadStatus.NEW)
                    writer.write("New Leads,${leads.count { it.status.name == "NEW" }}\n")
                    writer.write("Contacted Leads,${leads.count { it.status.name == "CONTACTED" }}\n")
                    writer.write("Qualified Leads,${leads.count { it.status.name == "QUALIFIED" }}\n")
                    writer.write("Proposal Leads,${leads.count { it.status.name == "PROPOSAL" }}\n")
                    writer.write("Negotiation Leads,${leads.count { it.status.name == "NEGOTIATION" }}\n")
                    writer.write("Won Leads,${leads.count { it.status.name == "WON" }}\n")
                    writer.write("Lost Leads,${leads.count { it.status.name == "LOST" }}\n")
                    writer.write("Total Lead Value (USD),${leads.sumOf { it.valueUSD ?: 0.0 }}\n") // Null safety
                    writer.write("Total Weighted Lead Value (USD),${leads.sumOf { it.weightedValueUSD ?: 0.0 }}\n\n") // Null safety

                    // Target statistics
                    writer.write("TARGET STATISTICS\n")
                    writer.write("Total Targets,${targets.size}\n")
                    writer.write("Completed Targets,${targets.count { it.isCompleted }}\n")
                    writer.write("Completion Rate,${if (targets.isNotEmpty()) targets.count { it.isCompleted }.toFloat() / targets.size * 100 else 0}%\n")
                    // TODO: Replace string comparisons with enum comparisons if enums exist (e.g., TargetCategory.REVENUE)
                    writer.write("Revenue Targets,${targets.count { it.category.name == "REVENUE" }}\n")
                    writer.write("Client Targets,${targets.count { it.category.name == "NEW_CLIENTS" }}\n")
                    writer.write("Lead Targets,${targets.count { it.category.name == "LEADS_GENERATED" }}\n")
                    writer.write("Call Targets,${targets.count { it.category.name == "CALLS_MADE" }}\n\n")

                    // Outreach statistics
                    writer.write("OUTREACH STATISTICS\n")
                    writer.write("Total Activities,${outreachActivities.size}\n")
                    // TODO: Replace string comparisons with enum comparisons if enums exist (e.g., OutreachType.CALL)
                    writer.write("Calls,${outreachActivities.count { it.type.name == "CALL" }}\n")
                    writer.write("Emails,${outreachActivities.count { it.type.name == "EMAIL" }}\n")
                    writer.write("Meetings,${outreachActivities.count { it.type.name == "MEETING" }}\n")
                    writer.write("Social Media,${outreachActivities.count { it.type.name == "SOCIAL_MEDIA" }}\n")
                    // TODO: Replace string comparisons with enum comparisons if enums exist (e.g., OutreachOutcome.SUCCESSFUL)
                    writer.write("Successful Outcomes,${outreachActivities.count { it.outcome.name == "SUCCESSFUL" }}\n")
                    writer.write("No Response Outcomes,${outreachActivities.count { it.outcome.name == "NO_RESPONSE" }}\n")
                    writer.write("Interested Outcomes,${outreachActivities.count { it.outcome.name == "INTERESTED" }}\n")
                    writer.write("Not Interested Outcomes,${outreachActivities.count { it.outcome.name == "NOT_INTERESTED" }}\n")
                    writer.write("Follow-up Needed Outcomes,${outreachActivities.count { it.outcome.name == "FOLLOW_UP_NEEDED" }}\n")
                    val successfulOutcomes = outreachActivities.count { it.outcome.name == "SUCCESSFUL" || it.outcome.name == "INTERESTED" }
                    writer.write("Success Rate,${if (outreachActivities.isNotEmpty()) successfulOutcomes.toFloat() / outreachActivities.size * 100 else 0}%\n")
                    writer.write("Total Duration (minutes),${outreachActivities.sumOf { it.duration ?: 0 }}\n") // Null safety
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            // Log error appropriately
            false
        }
    }

    /**
     * Create a CSV file using Storage Access Framework (SAF).
     * NOTE: This function only provides the structure. The actual SAF intent launching
     * and result handling needs to be done in the Activity/Fragment.
     */
    fun createCsvFileSafIntent(fileName: String): Intent {
        // Recommend using ACTION_CREATE_DOCUMENT for better user experience and compatibility
        // This requires handling the result in the Activity/Fragment
        // Example:
        // val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
        //     addCategory(Intent.CATEGORY_OPENABLE)
        //     type = "text/csv"
        //     putExtra(Intent.EXTRA_TITLE, fileName)
        // }
        // activityResultLauncher.launch(intent)
        //
        // The hardcoded URI approach below is less reliable:
        // val downloadsDir = DocumentFile.fromTreeUri(context, Uri.parse("content://com.android.externalstorage.documents/tree/primary:Download"))
        // val file = downloadsDir?.createFile("text/csv", fileName)
        // return file?.uri
        throw UnsupportedOperationException("SAF Intent creation should be handled in Activity/Fragment")
    }

    /**
     * Escape special characters for CSV format (handles quotes, commas, newlines)
     */
    private fun escapeCsvField(text: String?): String {
        val field = text ?: "" // Handle null input
        return if (field.contains(",") || field.contains("\"") || field.contains("\n")) {
            // Escape quotes by doubling them and wrap field in quotes
            "\"${field.replace("\"", "\"\"")}\""
        } else {
            field
        }
    }
}

