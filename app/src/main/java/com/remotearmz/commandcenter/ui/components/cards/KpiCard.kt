package com.remotearmz.commandcenter.ui.components.cards

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.remotearmz.commandcenter.ui.theme.LocalSpacing

/**
 * An enhanced KPI (Key Performance Indicator) card component that displays a metric with title and optional icon.
 *
 * @param title The title of the KPI (e.g., "Total Revenue")
 * @param value The main value to display (e.g., "$12,345")
 * @param modifier Modifier to be applied to the card
 * @param subtitle Optional subtitle providing additional context
 * @param icon Optional icon to display next to the title
 * @param iconTint Tint color for the icon
 * @param backgroundColor Background color of the card
 * @param contentColor Color for the text content
 * @param elevation Elevation of the card
 * @param shape Shape of the card
 * @param showProgress Whether to show a progress indicator
 * @param progressValue The progress value (0f to 1f) if showProgress is true
 * @param progressColor Color of the progress indicator
 * @param onClick Optional click handler for making the card interactive
 */
@Composable
fun KpiCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    icon: ImageVector? = null,
    iconTint: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    elevation: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(16.dp),
    showProgress: Boolean = false,
    progressValue: Float = 0f,
    progressColor: Color = MaterialTheme.colorScheme.primary,
    onClick: (() -> Unit)? = null
) {
    val spacing = LocalSpacing.current
    val animatedBackgroundColor by animateColorAsState(
        targetValue = backgroundColor,
        label = "backgroundColorAnimation"
    )
    
    val cardModifier = modifier
        .fillMaxWidth()
        .shadow(
            elevation = elevation,
            shape = shape,
            clip = false
        )
        .clip(shape)
        .background(
            color = animatedBackgroundColor,
            shape = shape
        )
        .then(
            if (onClick != null) {
                Modifier.clickable(
                    onClick = onClick,
                    interactionSource = remember { NoRippleInteractionSource() },
                    indication = null
                )
            } else Modifier
        )

    Card(
        modifier = cardModifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        ),
        elevation = CardDefaults.cardElevation(0.dp),
        shape = shape
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.medium)
        ) {
            // Header with icon and title
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Optional icon
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = iconTint,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(spacing.small))
                }
                
                // Title
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge,
                    color = contentColor.copy(alpha = 0.8f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(spacing.small))
            
            // Main value
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = contentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            
            // Subtitle if provided
            if (!subtitle.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(spacing.extraSmall))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = contentColor.copy(alpha = 0.7f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            
            // Progress indicator if enabled
            if (showProgress) {
                Spacer(modifier = Modifier.height(spacing.small))
                LinearProgressIndicator(
                    progress = { progressValue.coerceIn(0f, 1f) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    color = progressColor,
                    trackColor = progressColor.copy(alpha = 0.2f)
                )
            }
        }
    }
}

/**
 * A preview of the KpiCard with different states
 */
@Preview(showBackground = true)
@Composable
private fun KpiCardPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Basic KPI card
            KpiCard(
                title = "Total Revenue",
                value = "$12,345",
                subtitle = "+12% from last month"
            )
            
            // KPI card with icon
            KpiCard(
                title = "Active Users",
                value = "1,234",
                subtitle = "+45 this week",
                icon = Icons.Default.BarChart,
                iconTint = MaterialTheme.colorScheme.primary
            )
            
            // KPI card with progress
            KpiCard(
                title = "Monthly Goal",
                value = "75%",
                subtitle = "$7,500 of $10,000",
                showProgress = true,
                progressValue = 0.75f,
                progressColor = MaterialTheme.colorScheme.tertiary,
                onClick = { /* Handle click */ }
            )
            
            // Colored KPI card
            KpiCard(
                title = "Conversion Rate",
                value = "24.5%",
                subtitle = "245 conversions",
                backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                onClick = { /* Handle click */ }
            )
        }
    }
}
