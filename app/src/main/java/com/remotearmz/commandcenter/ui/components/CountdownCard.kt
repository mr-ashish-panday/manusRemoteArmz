package com.remotearmz.commandcenter.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotearmz.commandcenter.ui.theme.RemoteArmzTheme
import com.remotearmz.commandcenter.util.DateCountdownUtil
import kotlinx.coroutines.delay

@Composable
fun CountdownCard(
    title: String,
    subtitle: String,
    daysRemaining: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Animated number
            var displayedDays by remember { mutableIntStateOf(daysRemaining) }
            
            LaunchedEffect(daysRemaining) {
                // Animate from current displayed value to target value
                val diff = daysRemaining - displayedDays
                val steps = 20 // Number of animation steps
                val increment = diff.toFloat() / steps
                
                repeat(steps) {
                    delay(16) // ~60fps
                    displayedDays = (displayedDays + increment).toInt()
                }
                
                // Ensure we end exactly at the target value
                displayedDays = daysRemaining
            }
            
            AnimatedContent(
                targetState = displayedDays,
                transitionSpec = {
                    fadeIn(animationSpec = tween(300)) togetherWith 
                    fadeOut(animationSpec = tween(300))
                },
                label = "Days counter animation"
            ) { days ->
                Text(
                    text = days.toString(),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DeadlineCountdown(
    modifier: Modifier = Modifier
) {
    val daysRemaining = DateCountdownUtil.getRemainingDaysUntilDeadline()
    
    CountdownCard(
        title = "Countdown to Deadline",
        subtitle = "Days remaining until May 30, 2026",
        daysRemaining = daysRemaining,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CountdownCardPreview() {
    RemoteArmzTheme {
        DeadlineCountdown(modifier = Modifier.padding(16.dp))
    }
}
