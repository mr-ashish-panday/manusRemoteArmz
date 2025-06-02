package com.remotearmz.commandcenter.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.TimerOff
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.remotearmz.commandcenter.ui.theme.RemoteArmzTheme
import com.remotearmz.commandcenter.util.DateCountdownUtil
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue

/**
 * Represents the state of the countdown
 */
sealed class CountdownState {
    data object Loading : CountdownState()
    data class Active(
        val daysRemaining: Int,
        val isToday: Boolean = false,
        val isPast: Boolean = false
    ) : CountdownState()
}

/**
 * A composable that displays a countdown to a target date with smooth animations and visual feedback
 *
 * @param title The title of the countdown (e.g., "Project Deadline")
 * @param targetDate The target date to count down to (in milliseconds since epoch)
 * @param modifier Modifier to be applied to the card
 * @param titleIcon Optional icon to display next to the title
 * @param showProgressBar Whether to show a progress bar (default: true)
 * @param onCountdownFinished Optional callback when the countdown reaches zero
 */
@Composable
fun CountdownCard(
    title: String,
    targetDate: Long,
    modifier: Modifier = Modifier,
    titleIcon: @Composable (() -> Unit)? = null,
    showProgressBar: Boolean = true,
    onCountdownFinished: (() -> Unit)? = null
) {
    val currentTime = remember { System.currentTimeMillis() }
    val daysRemaining = remember(targetDate) {
        DateCountdownUtil.getDaysUntil(targetDate)
    }
    
    val isPast = targetDate < currentTime
    val isToday = daysRemaining == 0 && !isPast
    
    // Notify when countdown reaches zero
    LaunchedEffect(daysRemaining) {
        if (daysRemaining == 0 && !isPast) {
            onCountdownFinished?.invoke()
        }
    }
    
    // Calculate progress (0f to 1f) for progress bar
    val progress = remember(targetDate) {
        val totalDays = 365 // 1 year as max range for progress
        (totalDays - daysRemaining).coerceIn(0, totalDays).toFloat() / totalDays
    }
    
    // Animated progress value
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000),
        label = "progress_animation"
    )
    
    // Container color based on countdown state
    val containerColor by animateColorAsState(
        targetValue = when {
            isToday -> MaterialTheme.colorScheme.tertiaryContainer
            isPast -> MaterialTheme.colorScheme.errorContainer
            else -> MaterialTheme.colorScheme.primaryContainer
        },
        label = "container_color_animation"
    )
    
    // Content color based on countdown state
    val contentColor by animateColorAsState(
        targetValue = when {
            isToday -> MaterialTheme.colorScheme.onTertiaryContainer
            isPast -> MaterialTheme.colorScheme.onErrorContainer
            else -> MaterialTheme.colorScheme.onPrimaryContainer
        },
        label = "content_color_animation"
    )
    
    // Format the target date
    val formattedDate = remember(targetDate) {
        val formatter = DateTimeFormatter.ofPattern("MMM d, yyyy")
        Instant.ofEpochMilli(targetDate)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
            .format(formatter)
    }
    
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Header with title and icon
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                titleIcon?.let { 
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(contentColor.copy(alpha = 0.1f))
                            .padding(4.dp)
                    ) {
                        it()
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = contentColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Main countdown display
            AnimatedContent(
                targetState = daysRemaining,
                transitionSpec = {
                    // Slide up when increasing, down when decreasing
                    val direction = if (targetState > initialState) 1 else -1
                    slideInVertically { height -> height * direction } + fadeIn() togetherWith
                            slideOutVertically { height -> -height * direction } + fadeOut()
                },
                label = "days_counter_animation"
            ) { days ->
                Column(
                    horizontalAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Large number
                    Text(
                        text = days.absoluteValue.toString(),
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 56.sp
                        ),
                        color = contentColor,
                        textAlign = TextAlign.Center
                    )
                    
                    // Label
                    Text(
                        text = when {
                            isToday -> "Today!"
                            isPast -> if (days == -1) "Day overdue" else "Days overdue"
                            days == 1 -> "Day to go"
                            else -> "Days to go"
                        },
                        style = MaterialTheme.typography.titleSmall,
                        color = contentColor.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Date and progress
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(contentColor.copy(alpha = 0.1f))
                    .padding(12.dp)
            ) {
                // Date row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = if (isToday || isPast) Icons.Default.Today else Icons.Default.Event,
                        contentDescription = null,
                        tint = contentColor.copy(alpha = 0.8f),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isToday) "Today" else formattedDate,
                        style = MaterialTheme.typography.bodyMedium,
                        color = contentColor.copy(alpha = 0.9f)
                    )
                }
                
                // Progress bar
                if (showProgressBar) {
                    Spacer(modifier = Modifier.height(12.dp))
                    LinearProgressIndicator(
                        progress = { animatedProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp)),
                        color = contentColor.copy(alpha = 0.5f),
                        trackColor = contentColor.copy(alpha = 0.1f)
                    )
                    
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Text(
                        text = "${(animatedProgress * 100).toInt()}% of time elapsed",
                        style = MaterialTheme.typography.labelSmall,
                        color = contentColor.copy(alpha = 0.7f)
                    )
                }
            }
        }
    }
}

/**
 * A countdown to a specific deadline with a title and optional icon
 * 
 * @param title The title of the deadline (e.g., "Project Deadline")
 * @param targetDate The target date in milliseconds since epoch
 * @param modifier Modifier to be applied to the card
 * @param showProgressBar Whether to show the progress bar (default: true)
 * @param onCountdownFinished Optional callback when the countdown reaches zero
 */
@Composable
fun DeadlineCountdown(
    title: String,
    targetDate: Long,
    modifier: Modifier = Modifier,
    showProgressBar: Boolean = true,
    onCountdownFinished: (() -> Unit)? = null
) {
    CountdownCard(
        title = title,
        targetDate = targetDate,
        modifier = modifier,
        titleIcon = {
            Icon(
                imageVector = if (targetDate < System.currentTimeMillis()) {
                    Icons.Default.TimerOff
                } else {
                    Icons.Default.Timer
                },
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        showProgressBar = showProgressBar,
        onCountdownFinished = onCountdownFinished
    )
}

/**
 * Example usage with a hardcoded date (for preview and testing)
 */
@Composable
fun ExampleDeadlineCountdown(
    modifier: Modifier = Modifier
) {
    // Example: 30 days from now
    val targetDate = remember {
        System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30)
    }
    
    DeadlineCountdown(
        title = "Project Deadline",
        targetDate = targetDate,
        modifier = modifier,
        onCountdownFinished = {
            // Handle countdown finished
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CountdownCardPreview() {
    RemoteArmzTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Future date
            DeadlineCountdown(
                title = "Project Deadline",
                targetDate = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7),
                modifier = Modifier.fillMaxWidth()
            )
            
            // Today
            DeadlineCountdown(
                title = "Task Due Today",
                targetDate = System.currentTimeMillis(),
                modifier = Modifier.fillMaxWidth()
            )
            
            // Past date
            DeadlineCountdown(
                title = "Overdue Task",
                targetDate = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(2),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
