package com.remotearmz.commandcenter.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.composable
import com.remotearmz.commandcenter.ui.clients.ClientsScreen
import com.remotearmz.commandcenter.ui.dashboard.DashboardScreen
import com.remotearmz.commandcenter.ui.leads.LeadScreen
import com.remotearmz.commandcenter.ui.outreach.OutreachScreen
import com.remotearmz.commandcenter.ui.settings.SettingsScreen
import com.remotearmz.commandcenter.ui.targets.TargetScreen

// Animation constants
private const val ANIMATION_DURATION = 300

// Navigation transitions
private fun slideInHorizontally(initialOffsetX: (Int) -> Int) =
    slideInHorizontally(
        initialOffsetX = initialOffsetX,
        animationSpec = tween(ANIMATION_DURATION)
    )

private fun slideOutHorizontally(targetOffsetX: (Int) -> Int) =
    slideOutHorizontally(
        targetOffsetX = targetOffsetX,
        animationSpec = tween(ANIMATION_DURATION)
    )

private fun fadeIn() = fadeIn(animationSpec = tween(ANIMATION_DURATION))
private fun fadeOut() = fadeOut(animationSpec = tween(ANIMATION_DURATION))

// Navigation composable with animations
private fun NavGraphBuilder.animatedComposable(
    route: String,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route,
        enterTransition = {
            slideInHorizontally { it } + fadeIn()
        },
        exitTransition = {
            slideOutHorizontally { -it } + fadeOut()
        },
        popEnterTransition = {
            slideInHorizontally { -it } + fadeIn()
        },
        popExitTransition = {
            slideOutHorizontally { it } + fadeOut()
        }
    ) { backStackEntry ->
        content(backStackEntry)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Dashboard.route,
        modifier = modifier
    ) {
        // Dashboard Screen
        animatedComposable(BottomNavItem.Dashboard.route) { backStackEntry ->
            // This ensures state is preserved when returning to this screen
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(BottomNavItem.Dashboard.route)
            }
            DashboardScreen()
        }

        // Clients Screen
        animatedComposable(BottomNavItem.Clients.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(BottomNavItem.Clients.route)
            }
            ClientsScreen()
        }

        // Leads Screen
        animatedComposable(BottomNavItem.Leads.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(BottomNavItem.Leads.route)
            }
            LeadScreen()
        }

        // Targets Screen
        animatedComposable(BottomNavItem.Targets.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(BottomNavItem.Targets.route)
            }
            TargetScreen()
        }

        // Outreach Screen
        animatedComposable(BottomNavItem.Outreach.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(BottomNavItem.Outreach.route)
            }
            OutreachScreen()
        }

        // Settings Screen (not in bottom nav)
        animatedComposable("settings") { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry("settings")
            }
            SettingsScreen()
        }
    }
}
