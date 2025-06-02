package com.remotearmz.commandcenter.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.ui.theme.LocalSpacing

private val BottomBarHeight = 80.dp
private const val ANIMATION_DURATION = 200

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val iconResId: Int,
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null
) {
    object Dashboard : BottomNavItem(
        route = "dashboard",
        title = "Dashboard",
        iconResId = R.drawable.ic_dashboard,
        selectedIcon = Icons.Filled.Dashboard,
        unselectedIcon = Icons.Outlined.Dashboard
    )
    
    object Clients : BottomNavItem(
        route = "clients",
        title = "Clients",
        iconResId = R.drawable.ic_clients,
        selectedIcon = Icons.Filled.People,
        unselectedIcon = Icons.Outlined.People
    )
    
    object Leads : BottomNavItem(
        route = "leads",
        title = "Leads",
        iconResId = R.drawable.ic_leads,
        selectedIcon = Icons.Filled.Star,
        unselectedIcon = Icons.Outlined.Star
    )
    
    object Targets : BottomNavItem(
        route = "targets",
        title = "Targets",
        iconResId = R.drawable.ic_targets,
        selectedIcon = Icons.Filled.TrackChanges,
        unselectedIcon = Icons.Outlined.TrackChanges
    )
    
    object Outreach : BottomNavItem(
        route = "outreach",
        title = "Outreach",
        iconResId = R.drawable.ic_outreach,
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.Email
    )
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Clients,
        BottomNavItem.Leads,
        BottomNavItem.Targets,
        BottomNavItem.Outreach
    )
    
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navBackStackEntry?.destination
    val spacing = LocalSpacing.current
    
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 8.dp,
        modifier = Modifier.height(BottomBarHeight)
    ) {
        items.forEach { item ->
            val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
            val contentColor = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
            
            NavigationBarItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        // Animated icon with background
                        Box(
                            contentAlignment = Alignment.center,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(
                                    if (selected) MaterialTheme.colorScheme.primaryContainer
                                    else Color.Transparent
                                )
                        ) {
                            item.selectedIcon?.let { selectedIcon ->
                                item.unselectedIcon?.let { unselectedIcon ->
                                    Crossfade(
                                        targetState = selected,
                                        label = "iconTransition"
                                    ) { isSelected ->
                                        Icon(
                                            imageVector = if (isSelected) selectedIcon else unselectedIcon,
                                            contentDescription = item.title,
                                            tint = if (isSelected) {
                                                MaterialTheme.colorScheme.onPrimaryContainer
                                            } else {
                                                MaterialTheme.colorScheme.onSurfaceVariant
                                            },
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                } ?: Icon(
                                    painter = painterResource(id = item.iconResId),
                                    contentDescription = item.title,
                                    tint = contentColor
                                )
                            } ?: Icon(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = item.title,
                                tint = contentColor
                            )
                        }
                        
                        // Label with animation
                        AnimatedVisibility(
                            visible = selected,
                            enter = fadeIn() + slideInVertically { -it / 2 },
                            exit = fadeOut() + slideInVertically { it / 2 }
                        ) {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.labelSmall,
                                color = contentColor,
                                maxLines = 1
                            )
                        }
                    }
                },
                selected = selected,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                            // Add animation for better feedback
                            navController.currentBackStackEntry?.destination?.let { destination ->
                                if (destination.hierarchy.any { it.route == item.route }) {
                                    // Already on this destination, do nothing
                                    return@navigate
                                }
                            }
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorShape = CircleShape
                ),
                alwaysShowLabel = false
            )
        }
    }
}
