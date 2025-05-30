package com.remotearmz.commandcenter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.remotearmz.commandcenter.ui.clients.ClientsScreen
import com.remotearmz.commandcenter.ui.dashboard.DashboardScreen
import com.remotearmz.commandcenter.ui.leads.LeadScreen
import com.remotearmz.commandcenter.ui.outreach.OutreachScreen
import com.remotearmz.commandcenter.ui.settings.SettingsScreen
import com.remotearmz.commandcenter.ui.targets.TargetScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = BottomNavItem.Dashboard.route, modifier = modifier) {
        composable(BottomNavItem.Dashboard.route) {
            DashboardScreen()
        }
        composable(BottomNavItem.Clients.route) {
            ClientsScreen()
        }
        composable(BottomNavItem.Leads.route) {
            LeadScreen()
        }
        composable(BottomNavItem.Targets.route) {
            TargetScreen()
        }
        composable(BottomNavItem.Outreach.route) {
            OutreachScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
