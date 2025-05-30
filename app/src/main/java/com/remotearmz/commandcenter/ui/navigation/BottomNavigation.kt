package com.remotearmz.commandcenter.ui.navigation

import androidx.compose.ui.res.painterResource
import com.remotearmz.commandcenter.R
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

sealed class BottomNavItem(val route: String, val title: String, val iconResId: Int) {
    object Dashboard : BottomNavItem(
        route = "dashboard",
        title = "Dashboard",
        iconResId = R.drawable.ic_dashboard
    )
    
    object Clients : BottomNavItem(
        route = "clients",
        title = "Clients",
        iconResId = R.drawable.ic_clients
    )
    
    object Leads : BottomNavItem(
        route = "leads",
        title = "Leads",
        iconResId = R.drawable.ic_leads
    )
    
    object Targets : BottomNavItem(
        route = "targets",
        title = "Targets",
        iconResId = R.drawable.ic_targets
    )
    
    object Outreach : BottomNavItem(
        route = "outreach",
        title = "Outreach",
        iconResId = R.drawable.ic_outreach
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
    
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}
