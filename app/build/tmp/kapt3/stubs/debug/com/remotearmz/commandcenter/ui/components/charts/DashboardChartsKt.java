package com.remotearmz.commandcenter.ui.components.charts;

import androidx.compose.foundation.layout.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.*;
import com.github.mikephil.charting.formatter.ValueFormatter;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005H\u0007\u001a$\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007\u001a8\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0007H\u0007\u001a\u001a\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005H\u0002\u001a\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005H\u0002\u00a8\u0006\u000f"}, d2 = {"ConversionBarChart", "", "modifier", "Landroidx/compose/ui/Modifier;", "data", "", "Lkotlin/Pair;", "", "", "ProgressDonutChart", "progress", "label", "RevenueLineChart", "generateSampleConversionData", "generateSampleRevenueData", "app_debug"})
public final class DashboardChartsKt {
    
    @androidx.compose.runtime.Composable
    public static final void RevenueLineChart(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> data, @org.jetbrains.annotations.NotNull
    java.lang.String label) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ProgressDonutChart(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, float progress, @org.jetbrains.annotations.NotNull
    java.lang.String label) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ConversionBarChart(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> data) {
    }
    
    private static final java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> generateSampleRevenueData() {
        return null;
    }
    
    private static final java.util.List<kotlin.Pair<java.lang.String, java.lang.Float>> generateSampleConversionData() {
        return null;
    }
}