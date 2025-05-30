package com.remotearmz.commandcenter.ui.dashboard

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.remotearmz.commandcenter.ui.components.CountdownCard
import com.remotearmz.commandcenter.ui.components.DeadlineCountdown
import com.remotearmz.commandcenter.ui.components.KpiCard
import com.remotearmz.commandcenter.ui.theme.RemoteArmzTheme
import com.remotearmz.commandcenter.util.CurrencyFormatter
import com.remotearmz.commandcenter.util.DateCountdownUtil

@Composable
fun DashboardScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var revenue by remember { mutableStateOf(5000.0) } // Initial revenue in USD
        var clientCount by remember { mutableStateOf(12) }
        var leadCount by remember { mutableStateOf(24) }
        var targetProgress by remember { mutableStateOf(65f) }
        var successRate by remember { mutableStateOf(72f) }
        
        val revenueNPR = revenue * 135.0 // Convert USD to NPR
        val formattedRevenueNPR = CurrencyFormatter.formatNPR(revenueNPR)
        val formattedRevenueUSD = CurrencyFormatter.formatUSD(revenue)
        
        // Animate the target progress
        val animatedProgress by animateFloatAsState(
            targetValue = targetProgress / 100f,
            label = "Progress Animation"
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Dashboard",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Countdown card
            DeadlineCountdown(
                modifier = Modifier.padding(bottom = 24.dp)
            )
            
            // KPI Cards - Row 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KpiCard(
                    title = "Total Clients",
                    value = clientCount.toString(),
                    subtitle = "Active accounts",
                    modifier = Modifier.weight(1f)
                )
                
                KpiCard(
                    title = "Active Leads",
                    value = leadCount.toString(),
                    subtitle = "Potential clients",
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // KPI Cards - Row 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KpiCard(
                    title = "Revenue",
                    value = formattedRevenueNPR,
                    subtitle = formattedRevenueUSD,
                    modifier = Modifier.weight(1f)
                )
                
                KpiCard(
                    title = "Success Rate",
                    value = "${successRate.toInt()}%",
                    subtitle = "Outreach effectiveness",
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Target Progress Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Target Progress",
                        style = MaterialTheme.typography.titleMedium
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${targetProgress.toInt()}%",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Text(
                            text = "Goal: 100%",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    LinearProgressIndicator(
                        progress = animatedProgress,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Quick Actions Section
            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        // Simulate data updates
                        revenue += 500.0
                        clientCount += 1
                        leadCount += 2
                        targetProgress = (targetProgress + 5f).coerceAtMost(100f)
                        successRate = (successRate + 3f).coerceAtMost(100f)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Update Data")
                }
                
                Button(
                    onClick = { /* Export functionality */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Export CSV")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    RemoteArmzTheme {
        DashboardScreen()
    }
}
