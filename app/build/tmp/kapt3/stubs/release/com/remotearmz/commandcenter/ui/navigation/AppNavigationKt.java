package com.remotearmz.commandcenter.ui.navigation;

import androidx.compose.animation.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import com.google.accompanist.navigation.animation.composable;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\b\u0010\b\u001a\u00020\tH\u0002\u001a\b\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a\u001c\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000eH\u0002\u001a-\u0010\u0011\u001a\u00020\u0003*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u000e\u00a2\u0006\u0002\b\u0017H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"ANIMATION_DURATION", "", "AppNavigation", "", "navController", "Landroidx/navigation/NavHostController;", "modifier", "Landroidx/compose/ui/Modifier;", "fadeIn", "Landroidx/compose/animation/EnterTransition;", "fadeOut", "Landroidx/compose/animation/ExitTransition;", "slideInHorizontally", "initialOffsetX", "Lkotlin/Function1;", "slideOutHorizontally", "targetOffsetX", "animatedComposable", "Landroidx/navigation/NavGraphBuilder;", "route", "", "content", "Landroidx/navigation/NavBackStackEntry;", "Landroidx/compose/runtime/Composable;", "app_release"})
public final class AppNavigationKt {
    private static final int ANIMATION_DURATION = 300;
    
    private static final androidx.compose.animation.EnterTransition slideInHorizontally(kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Integer> initialOffsetX) {
        return null;
    }
    
    private static final androidx.compose.animation.ExitTransition slideOutHorizontally(kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Integer> targetOffsetX) {
        return null;
    }
    
    private static final androidx.compose.animation.EnterTransition fadeIn() {
        return null;
    }
    
    private static final androidx.compose.animation.ExitTransition fadeOut() {
        return null;
    }
    
    private static final void animatedComposable(androidx.navigation.NavGraphBuilder $this$animatedComposable, java.lang.String route, kotlin.jvm.functions.Function1<? super androidx.navigation.NavBackStackEntry, kotlin.Unit> content) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.animation.ExperimentalAnimationApi.class})
    public static final void AppNavigation(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
}