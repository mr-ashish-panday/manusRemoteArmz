package com.remotearmz.commandcenter.util

import android.content.Context
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
            val outputStream = context.contentResolver.openOutputStream(uri)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            
            // Write header
            writer.write("ID,Name,Company,Phone,Email,Contract Value (USD),Contract Value (NPR),Status,Tags,Notes,Last Contact Date,Created At,Updated At\n")
            
            // Write data
            clients.forEach { client ->
                val row = listOf(
                    client.id,
                    escapeSpecialCharacters(client.name),
                    escapeSpecialCharacters(client.company),
                    escapeSpecialCharacters(client.phone),
                    escapeSpecialCharacters(client.email),
                    client.contractValueUSD.toString(),
                    client.contractValueNPR.toString(),
                    client.status.name,
                    escapeSpecialCharacters(client.tags.joinToString("|")),
                    escapeSpecialCharacters(client.notes),
                    client.lastContactDate?.let { dateFormat.format(Date(it)) } ?: "",
                    dateFormat.format(Date(client.createdAt)),
                    dateFormat.format(Date(client.updatedAt))
                ).joinToString(",")
                
                writer.write("$row\n")
            }
            
            writer.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    
    /**
     * Export leads to CSV file
     */
    suspend fun exportLeads(leads: List<Lead>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            val outputStream = context.contentResolver.openOutputStream(uri)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            
            // Write header
            writer.write("ID,Contact Name,Company,Phone,Email,Status,Value (USD),Value (NPR),Probability,Weighted Value (USD),Weighted Value (NPR),Source,Expected Close Date,Client ID,Created At,Updated At\n")
            
            // Write data
            leads.forEach { lead ->
                val row = listOf(
                    lead.id,
                    escapeSpecialCharacters(lead.contactName),
                    escapeSpecialCharacters(lead.company),
                    escapeSpecialCharacters(lead.phone),
                    escapeSpecialCharacters(lead.email),
                    lead.status.name,
                    lead.valueUSD.toString(),
                    lead.valueNPR.toString(),
                    lead.probability.toString(),
                    lead.weightedValueUSD.toString(),
                    lead.weightedValueNPR.toString(),
                    escapeSpecialCharacters(lead.source),
                    lead.expectedCloseDate?.let { dateFormat.format(Date(it)) } ?: "",
                    lead.clientId ?: "",
                    dateFormat.format(Date(lead.createdAt)),
                    dateFormat.format(Date(lead.updatedAt))
                ).joinToString(",")
                
                writer.write("$row\n")
            }
            
            writer.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    
    /**
     * Export targets to CSV file
     */
    suspend fun exportTargets(targets: List<Target>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            val outputStream = context.contentResolver.openOutputStream(uri)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            
            // Write header
            writer.write("ID,Title,Category,Target Value,Current Value,Progress %,Deadline,Days Remaining,Description,Priority,Completed,Created At\n")
            
            // Write data
            targets.forEach { target ->
                val row = listOf(
                    target.id,
                    escapeSpecialCharacters(target.title),
                    target.category.name,
                    target.targetValue.toString(),
                    target.currentValue.toString(),
                    target.progressPercentage.toString(),
                    dateFormat.format(Date(target.deadline)),
                    target.remainingDays.toString(),
                    escapeSpecialCharacters(target.description),
                    target.priority.name,
                    target.isCompleted.toString(),
                    dateFormat.format(Date(target.createdAt))
                ).joinToString(",")
                
                writer.write("$row\n")
            }
            
            writer.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    
    /**
     * Export outreach activities to CSV file
     */
    suspend fun exportOutreachActivities(activities: List<OutreachActivity>, uri: Uri): Boolean = withContext(Dispatchers.IO) {
        try {
            val outputStream = context.contentResolver.openOutputStream(uri)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            
            // Write header
            writer.write("ID,Type,Contact ID,Contact Type,Outcome,Notes,Duration (minutes),Follow-up Required,Follow-up Date,Created At\n")
            
            // Write data
            activities.forEach { activity ->
                val row = listOf(
                    activity.id,
                    activity.type.name,
                    activity.contactId,
                    activity.contactType.name,
                    activity.outcome.name,
                    escapeSpecialCharacters(activity.notes),
                    activity.duration.toString(),
                    activity.followUpRequired.toString(),
                    activity.followUpDate?.let { dateFormat.format(Date(it)) } ?: "",
                    dateFormat.format(Date(activity.createdAt))
                ).joinToString(",")
                
                writer.write("$row\n")
            }
            
            writer.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
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
            val outputStream = context.contentResolver.openOutputStream(uri)
            val writer = BufferedWriter(OutputStreamWriter(outputStream))
            
            // Write report header
            writer.write("REMOTEARMZ COMMAND CENTER - ANALYTICS REPORT\n")
            writer.write("Generated: ${dateFormat.format(Date())}\n\n")
            
            // Client statistics
            writer.write("CLIENT STATISTICS\n")
            writer.write("Total Clients,${clients.size}\n")
            writer.write("Active Clients,${clients.count { it.status.name == "ACTIVE" }}\n")
            writer.write("Inactive Clients,${clients.count { it.status.name == "INACTIVE" }}\n")
            writer.write("Prospect Clients,${clients.count { it.status.name == "PROSPECT" }}\n")
            writer.write("Total Contract Value (USD),${clients.sumOf { it.contractValueUSD }}\n")
            writer.write("Total Contract Value (NPR),${clients.sumOf { it.contractValueNPR }}\n\n")
            
            // Lead statistics
            writer.write("LEAD STATISTICS\n")
            writer.write("Total Leads,${leads.size}\n")
            writer.write("New Leads,${leads.count { it.status.name == "NEW" }}\n")
            writer.write("Contacted Leads,${leads.count { it.status.name == "CONTACTED" }}\n")
            writer.write("Qualified Leads,${leads.count { it.status.name == "QUALIFIED" }}\n")
            writer.write("Proposal Leads,${leads.count { it.status.name == "PROPOSAL" }}\n")
            writer.write("Negotiation Leads,${leads.count { it.status.name == "NEGOTIATION" }}\n")
            writer.write("Won Leads,${leads.count { it.status.name == "WON" }}\n")
            writer.write("Lost Leads,${leads.count { it.status.name == "LOST" }}\n")
            writer.write("Total Lead Value (USD),${leads.sumOf { it.valueUSD }}\n")
            writer.write("Total Weighted Lead Value (USD),${leads.sumOf { it.weightedValueUSD }}\n\n")
            
            // Target statistics
            writer.write("TARGET STATISTICS\n")
            writer.write("Total Targets,${targets.size}\n")
            writer.write("Completed Targets,${targets.count { it.isCompleted }}\n")
            writer.write("Completion Rate,${if (targets.isNotEmpty()) targets.count { it.isCompleted }.toFloat() / targets.size * 100 else 0}%\n")
            writer.write("Revenue Targets,${targets.count { it.category.name == "REVENUE" }}\n")
            writer.write("Client Targets,${targets.count { it.category.name == "NEW_CLIENTS" }}\n")
            writer.write("Lead Targets,${targets.count { it.category.name == "LEADS_GENERATED" }}\n")
            writer.write("Call Targets,${targets.count { it.category.name == "CALLS_MADE" }}\n\n")
            
            // Outreach statistics
            writer.write("OUTREACH STATISTICS\n")
            writer.write("Total Activities,${outreachActivities.size}\n")
            writer.write("Calls,${outreachActivities.count { it.type.name == "CALL" }}\n")
            writer.write("Emails,${outreachActivities.count { it.type.name == "EMAIL" }}\n")
            writer.write("Meetings,${outreachActivities.count { it.type.name == "MEETING" }}\n")
            writer.write("Social Media,${outreachActivities.count { it.type.name == "SOCIAL_MEDIA" }}\n")
            writer.write("Successful Outcomes,${outreachActivities.count { it.outcome.name == "SUCCESSFUL" }}\n")
            writer.write("No Response Outcomes,${outreachActivities.count { it.outcome.name == "NO_RESPONSE" }}\n")
            writer.write("Interested Outcomes,${outreachActivities.count { it.outcome.name == "INTERESTED" }}\n")
            writer.write("Not Interested Outcomes,${outreachActivities.count { it.outcome.name == "NOT_INTERESTED" }}\n")
            writer.write("Follow-up Needed Outcomes,${outreachActivities.count { it.outcome.name == "FOLLOW_UP_NEEDED" }}\n")
            writer.write("Success Rate,${if (outreachActivities.isNotEmpty()) outreachActivities.count { it.outcome.name == "SUCCESSFUL" || it.outcome.name == "INTERESTED" }.toFloat() / outreachActivities.size * 100 else 0}%\n")
            writer.write("Total Duration (minutes),${outreachActivities.sumOf { it.duration }}\n")
            
            writer.close()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    
    /**
     * Create a CSV file with the given name in the Downloads directory
     */
    fun createCsvFile(fileName: String): Uri? {
        return try {
            val downloadsDir = DocumentFile.fromTreeUri(context, Uri.parse("content://com.android.externalstorage.documents/tree/primary:Download"))
            val file = downloadsDir?.createFile("text/csv", fileName)
            file?.uri
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    
    /**
     * Escape special characters for CSV format
     */
    private fun escapeSpecialCharacters(text: String): String {
        return if (text.contains(",") || text.contains("\"") || text.contains("\n")) {
            // Escape quotes by doubling them and wrap in quotes
            "\"${text.replace("\"", "\"\"")}\"" 
        } else {
            text
        }
    }
}
