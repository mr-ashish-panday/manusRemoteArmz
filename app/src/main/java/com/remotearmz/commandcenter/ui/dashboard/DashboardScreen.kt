package com.remotearmz.commandcenter.ui.dashboard

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.interaction.rememberInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.mergeDescendants
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.ui.components.cards.KpiCard
import com.remotearmz.commandcenter.ui.components.charts.ConversionBarChart
import com.remotearmz.commandcenter.ui.components.charts.ProgressDonutChart
import com.remotearmz.commandcenter.ui.components.charts.RevenueLineChart
import com.remotearmz.commandcenter.ui.theme.animateFloatingActionButton
import com.remotearmz.commandcenter.ui.theme.animateItemAppearance
import com.remotearmz.commandcenter.ui.theme.scaleOnPress
import com.remotearmz.commandcenter.util.CurrencyConverter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime

// Animation constants
private const val ITEM_ANIMATION_DELAY = 50L
private const val FADE_IN_DURATION = 400
private const val SCALE_ANIMATION_DURATION = 150

// Animation specs
private val itemAppearAnimation = fadeIn(
    animationSpec = tween(FADE_IN_DURATION)
) + slideInVertically(
    initialOffsetY = { it / 2 },
    animationSpec = tween(FADE_IN_DURATION)
)

// Data classes for dashboard items
data class QuickAction(
    val title: String,
    val icon: ImageVector,
    val color: Color,
    val badgeCount: Int = 0,
    val onClick: () -> Unit = {}
)

data class LeadStatusCard(
    val status: LeadStatus,
    val count: Int,
    val target: Int,
    val color: Color,
    val icon: ImageVector,
    val onClick: () -> Unit = {}
) {
    val progress: Float get() = (count.toFloat() / target).coerceIn(0f, 1f)
}

// Removed in favor of the more flexible KpiCard component

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onNavigateToLeads: () -> Unit = {},
    onAddNewLead: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    val greeting = remember { getGreeting() }
    val scope = rememberCoroutineScope()
    var showNewLeadDialog by remember { mutableStateOf(false) }
    
    // Pull to refresh state
    var refreshing by remember { mutableStateOf(false) }
    
    fun refresh() = scope.launch {
        refreshing = true
        viewModel.refreshData()
        refreshing = false
    }
    
    LaunchedEffect(Unit) {
        if (uiState.monthlyRevenue.isEmpty()) {
            refresh()
        }
    }
    
    // Lead status cards
    val leadStatuses = listOf(
        LeadStatusCard(
            status = LeadStatus.NEW,
            count = uiState.newLeads,
            target = uiState.leadTarget,
            color = MaterialTheme.colorScheme.primary,
            icon = Icons.Default.AddCircle,
            onClick = { viewModel.filterLeadsByStatus(LeadStatus.NEW) }
        ),
        LeadStatusCard(
            status = LeadStatus.CONTACTED,
            count = uiState.contactedLeads,
            target = uiState.leadTarget,
            color = MaterialTheme.colorScheme.secondary,
            icon = Icons.Default.Phone,
            onClick = { viewModel.filterLeadsByStatus(LeadStatus.CONTACTED) }
        ),
        LeadStatusCard(
            status = LeadStatus.QUALIFIED,
            count = uiState.qualifiedLeads,
            target = uiState.leadTarget,
            color = MaterialTheme.colorScheme.tertiary,
            icon = Icons.Default.Star,
            onClick = { viewModel.filterLeadsByStatus(LeadStatus.QUALIFIED) }
        ),
        LeadStatusCard(
            status = LeadStatus.CLOSED_WON,
            count = uiState.closedWonLeads,
            target = uiState.leadTarget,
            color = Color(0xFF2E7D32),
            icon = Icons.Default.CheckCircle,
            onClick = { viewModel.filterLeadsByStatus(LeadStatus.CLOSED_WON) }
        )
    )
    
    // Quick actions
    val quickActions = listOf(
        QuickAction(
            title = "New Lead",
            icon = Icons.Default.PersonAdd,
            color = MaterialTheme.colorScheme.primary,
            onClick = { showNewLeadDialog = true }
        ),
        QuickAction(
            title = "View All",
            icon = Icons.Default.List,
            color = MaterialTheme.colorScheme.secondary,
            badgeCount = uiState.totalLeads,
            onClick = onNavigateToLeads
        ),
        QuickAction(
            title = "Follow Up",
            icon = Icons.Default.NotificationsActive,
            color = MaterialTheme.colorScheme.tertiary,
            badgeCount = uiState.followUpLeads,
            onClick = { viewModel.filterFollowUpLeads() }
        )
    )
    
    // Lead conversion metrics
    val leadConversionRate = if (uiState.totalLeads > 0) {
        (uiState.closedWonLeads.toFloat() / uiState.totalLeads * 100).toInt()
    } else 0
    
    val avgDealSize = if (uiState.closedWonLeads > 0) {
        uiState.totalRevenue / uiState.closedWonLeads
    } else 0.0
    
    // Format data for display
    val formattedTotalRevenue = CurrencyConverter.formatNPR(uiState.totalRevenue * 135.0)
    val formattedRevenueUSD = CurrencyConverter.formatUSD(uiState.totalRevenue)
    val formattedAvgDealSize = CurrencyConverter.formatUSD(avgDealSize)
    
    // Metrics cards with enhanced KpiCard
    val metrics = listOf(
        KpiCard(
            title = "Total Revenue",
            value = formattedTotalRevenue,
            subtitle = formattedRevenueUSD,
            icon = Icons.Default.TrendingUp,
            iconTint = MaterialTheme.colorScheme.primary,
            showProgress = true,
            progressValue = (uiState.totalRevenue / 300000).coerceIn(0f, 1f),
            progressColor = MaterialTheme.colorScheme.primary,
            onClick = { /* Navigate to revenue details */ }
        ),
        KpiCard(
            title = "Conversion Rate",
            value = "$leadConversionRate%",
            subtitle = "${uiState.closedWonLeads}/${uiState.totalLeads} leads",
            icon = Icons.Default.Leaderboard,
            iconTint = MaterialTheme.colorScheme.secondary,
            showProgress = true,
            progressValue = leadConversionRate / 100f,
            progressColor = MaterialTheme.colorScheme.secondary,
            onClick = { /* Navigate to conversion analytics */ }
        ),
        KpiCard(
            title = "Avg Deal Size",
            value = formattedAvgDealSize,
            subtitle = "${uiState.avgSalesCycleDays}d sales cycle",
            icon = Icons.Default.Timeline,
            iconTint = MaterialTheme.colorScheme.tertiary,
            backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            onClick = { /* Navigate to deal analytics */ }
        )
    )
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
                    .systemBarsPadding()
            ) {
                // Header with greeting and actions
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "$greeting, Ashish!",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "${uiState.totalLeads} leads • ${uiState.activeClients} active",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                // Quick actions
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    // Notification bell
                    BadgedBox(
                        badge = { 
                            if (uiState.pendingActions > 0) {
                                Badge(containerColor = MaterialTheme.colorScheme.error) {
                                    Text(uiState.pendingActions.toString())
                                }
                            }
                        }
                    ) {
                        IconButton(onClick = { viewModel.showNotifications() }) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notifications"
                            )
                        }
                    }
                    
                    // Add lead FAB with enhanced visual feedback
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp), // Increased padding for better touch target
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        var isFabVisible by remember { mutableStateOf(false) }
                        
                        // Animate FAB appearance with a slight delay
                        LaunchedEffect(Unit) {
                            delay(300) // Delay for better visual hierarchy
                            isFabVisible = true
                        }
                        
                        // Animated FAB with enhanced visual feedback
                        FloatingActionButton(
                            onClick = { showNewLeadDialog = true },
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            elevation = FloatingActionButtonDefaults.elevation(
                                defaultElevation = 4.dp,
                                pressedElevation = 8.dp,
                                focusedElevation = 6.dp,
                                hoveredElevation = 6.dp
                            ),
                            shape = CircleShape,
                            modifier = Modifier
                                .size(56.dp) // Standard FAB size
                                .graphicsLayer {
                                    scaleX = if (isFabVisible) 1f else 0f
                                    scaleY = if (isFabVisible) 1f else 0f
                                    alpha = if (isFabVisible) 1f else 0f
                                }
                                .scaleOnPress(
                                    onPress = { isPressed -> 
                                        // Visual feedback on press
                                    },
                                    scale = 0.9f
                                )
                        ) {
                            // Icon with rotation animation on press
                            var isPressed by remember { mutableStateOf(false) }
                            val rotation by animateFloatAsState(
                                targetValue = if (isPressed) 45f else 0f,
                                animationSpec = tween(
                                    durationMillis = 200,
                                    easing = FastOutSlowInEasing
                                ),
                                label = "fab_icon_rotation"
                            )
                            
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add new lead",
                                modifier = Modifier
                                    .size(24.dp)
                                    .graphicsLayer {
                                        rotationZ = rotation
                                    }
                                    .semantics(mergeDescendants = true) {
                                        contentDescription = "Add new lead"
                                        role = Role.Button
                                    }
                            )
                            // Ripple effect on press
                            LaunchedEffect(isPressed) {
                                if (isPressed) {
                                    delay(200)
                                    isPressed = false
                                }
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Section header with consistent styling
            var isHeaderVisible by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) {
                delay(100) // Small delay for better visual hierarchy
                isHeaderVisible = true
            }
            
            Text(
                text = "Lead Pipeline",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = if (isHeaderVisible) 1f else 0f
                        translationY = if (isHeaderVisible) 0f else 10f
                    }
                    .animateContentSize()
                    .padding(vertical = 8.dp) // Consistent vertical padding
            )
            
            // Lead status cards with staggered animations
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                itemsIndexed(leadStatuses) { index, status ->
                    var isItemVisible by remember { mutableStateOf(false) }
                    
                    // Animate item appearance with staggered delay
                    LaunchedEffect(Unit) {
                        delay((index * 50).toLong())
                        isItemVisible = true
                    }
                    
                    // Apply staggered animation
                    Box(
                        modifier = Modifier
                            .graphicsLayer {
                                alpha = if (isItemVisible) 1f else 0f
                                translationY = if (isItemVisible) 0f else 20f
                            }
                            .animateContentSize()
                    ) {
                        LeadStatusItem(
                            status = status,
                            index = index
                        )
                    }
                }
            }
            
            // Metrics section with consistent header
            Spacer(modifier = Modifier.height(24.dp)) // Consistent section spacing
            
            // Section header with animation
            Text(
                text = "Key Metrics",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = if (isHeaderVisible) 1f else 0f
                        translationY = if (isHeaderVisible) 0f else 10f
                    }
                    .animateContentSize()
                    .padding(vertical = 8.dp) // Consistent vertical padding
            )
            
            // Metrics grid with responsive layout
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                itemsIndexed(metrics) { index, metric ->
                    // Responsive card sizing
                    val widthFraction = when {
                        metrics.size <= 2 -> 0.9f // Full width for 1-2 metrics
                        index == 0 -> 0.9f // First card slightly larger
                        else -> 0.42f // Two cards per row on larger screens
                    }
                    
                    // Staggered animation delay
                    val delay = (index * 50).toLong()
                    
                    // Animate appearance with scale and fade
                    var isVisible by remember { mutableStateOf(false) }
                    val alpha by animateFloatAsState(
                        targetValue = if (isVisible) 1f else 0f,
                        animationSpec = tween(
                            durationMillis = 300,
                            delayMillis = delay.toInt(),
                            easing = FastOutSlowInEasing
                        ),
                        label = "kpi_card_alpha_$index"
                    )
                    val scale by animateFloatAsState(
                        targetValue = if (isVisible) 1f else 0.9f,
                        animationSpec = spring(
                            dampingRatio = 0.6f,
                            stiffness = 800f
                        ),
                        label = "kpi_card_scale_$index"
                    )
                    
                    LaunchedEffect(Unit) {
                        delay(delay)
                        isVisible = true
                    }
                    
                    Box(
                        modifier = Modifier
                            .width((LocalConfiguration.current.screenWidthDp.dp - 32.dp) * widthFraction)
                            .padding(vertical = 4.dp)
                            .graphicsLayer {
                                this.alpha = alpha
                                this.scaleX = scale
                                this.scaleY = scale
                            }
                    ) {
                        // Metric card with consistent styling and feedback
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.surfaceContainerHigh,
                            tonalElevation = 1.dp,
                            shadowElevation = 0.dp,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable(role = Role.Button) {
                                    metric.onClick?.invoke()
                                }
                                .semantics(mergeDescendants = true) {
                                    contentDescription = metric.title
                                    role = Role.Button
                                }
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                            ) {
                                metric.content()
                            }
                        }
                    }
                }
            }
        }
            }
            
            // FAB with scale and bounce animation
            var isFabVisible by remember { mutableStateOf(false) }
            var fabScale by remember { mutableStateOf(1f) }
            var fabBounce by remember { mutableStateOf(1f) }
            val fabAnimation = remember { Animatable(0f) }

            // Animate FAB on appear
            LaunchedEffect(Unit) {
                // Bounce animation
                fabBounce = 1.2f
                fabAnimation.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                ) {
                    fabBounce = 1f
                }
                
                // Scale in animation
                delay(300) // Slight delay for better visual hierarchy
                isFabVisible = true
            }

            // FAB with combined animations
            FloatingActionButton(
                onClick = { showNewLeadDialog = true },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(16.dp)
                    .graphicsLayer {
                        scaleX = if (isFabVisible) fabScale * fabBounce else 0f
                        scaleY = if (isFabVisible) fabScale * fabBounce else 0f
                    }
                    .animateContentSize()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add new lead",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }

@Composable
private fun LeadStatusItem(
    status: LeadStatusCard,
    modifier: Modifier = Modifier,
    index: Int = 0
) {
    val progress = status.progress
    val progressAnimated by animateFloatAsState(
        targetValue = progress,
        animationSpec = spring(
            dampingRatio = 0.6f,
            stiffness = 800f
        ),
        label = "progress_animation"
    )
    
    // Animation states
    var isVisible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 300, delayMillis = index * ITEM_ANIMATION_DELAY)
    )
    LaunchedEffect(Unit) {
        delay((index * ITEM_ANIMATION_DELAY).toLong())
        isVisible = true
    }

    Card(
        onClick = status.onClick,
        modifier = modifier
            .width(160.dp)
            .padding(4.dp)
            .graphicsLayer {
                // Staggered fade and slide up animation
                alpha = if (isVisible) 1f else 0f
                translationY = if (isVisible) 0f else 20f
            }
            .animateContentSize()
            .scale(if (isVisible) 1f else 0.9f)
            .animateItemAppearance(index)
            .semantics(mergeDescendants = true) {
                contentDescription = "${status.status} status: ${status.count} of ${status.target} leads"
                role = Role.Button
            },
        colors = CardDefaults.cardColors(
            containerColor = status.color.copy(alpha = 0.1f),
            contentColor = status.color
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isVisible) 2.dp else 0.dp,
            pressedElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Icon with scale animation
                Icon(
                    imageVector = status.icon,
                    contentDescription = "${status.status} status icon",
                    modifier = Modifier
                        .size(24.dp) // Increased size for better visibility
                        .scale(if (isVisible) 1f else 0.5f)
                        .semantics(mergeDescendants = true) {}
                )
                
                // Status text with fade animation
                Text(
                    text = status.status.displayName,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .alpha(if (isVisible) 1f else 0f)
                )
                
                // Count with scale animation
                Text(
                    text = "${status.count}/${status.target}",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.scale(if (isVisible) 1f else 0.8f)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Animated progress bar
            LinearProgressIndicator(
                progress = { progressAnimated },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp)),
                color = status.color,
                trackColor = status.color.copy(alpha = 0.2f)
            )
        }
    }
}

@Composable
private fun QuickActionItem(
    action: QuickAction,
    modifier: Modifier = Modifier,
    index: Int = 0
) {
    var isPressed by remember { mutableStateOf(false) }
    var isVisible by remember { mutableStateOf(false) }
    
    // Animate item appearance with staggered delay
    LaunchedEffect(Unit) {
        delay((index * 50).toLong())
        isVisible = true
    }
    
    // Scale animation for press effect
    val scale by animateFloatAsState(
        targetValue = when {
            !isVisible -> 0.8f
            isPressed -> 0.95f
            else -> 1f
        },
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "quick_action_scale"
    )
    
    // Background color and elevation animations
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) 
            action.color.copy(alpha = 0.2f)
        else 
            action.color.copy(alpha = 0.1f),
        animationSpec = tween(durationMillis = 200),
        label = "quick_action_bg"
    )
    
    val elevation by animateDpAsState(
        targetValue = if (isPressed) 4.dp else 2.dp,
        animationSpec = tween(durationMillis = 200),
        label = "quick_action_elevation"
    )

    Surface(
        shape = CircleShape,
        color = backgroundColor,
        tonalElevation = elevation,
        shadowElevation = elevation,
        modifier = modifier
            .size(88.dp) // Increased size for better touch target
            .graphicsLayer {
                alpha = if (isVisible) 1f else 0f
                scaleX = scale
                scaleY = scale
                translationY = if (isVisible) 0f else 20f
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false, radius = 44.dp),
                role = Role.Button,
                onClick = { action.onClick() }
            )
            .semantics(mergeDescendants = true) {
                contentDescription = action.title
                this.role = Role.Button
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(12.dp)
        ) {
            // Icon with scale animation
            Icon(
                imageVector = action.icon,
                contentDescription = null,
                tint = action.color,
                modifier = Modifier.size(28.dp)
            )
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // Text with fade animation
            Text(
                text = action.title,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.3.sp
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    RemoteArmzTheme {
        val viewModel = DashboardViewModel()
        // Set some sample data for preview
        viewModel.uiState.value = viewModel.uiState.value.copy(
            totalLeads = 42,
            activeClients = 18,
            newLeads = 12,
            contactedLeads = 8,
            qualifiedLeads = 5,
            closedWonLeads = 3,
            closedLostLeads = 2,
            leadTarget = 50,
            pendingActions = 3,
            avgResponseTime = 2.5f,
            avgSalesCycleDays = 45,
            totalRevenue = 125000.0
        )
        DashboardScreen(
            viewModel = viewModel,
            onNavigateToLeads = {},
            onAddNewLead = {}
        )
    }
}
