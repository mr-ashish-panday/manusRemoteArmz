package com.remotearmz.commandcenter.ui.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;
import com.remotearmz.commandcenter.util.DateCountdownUtil;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u00a2\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0007\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0007\u001a>\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0007\u001a\u0012\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\u0011"}, d2 = {"CountdownCard", "", "title", "", "targetDate", "", "modifier", "Landroidx/compose/ui/Modifier;", "titleIcon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "showProgressBar", "", "onCountdownFinished", "CountdownCardPreview", "DeadlineCountdown", "ExampleDeadlineCountdown", "app_release"})
public final class CountdownCardKt {
    
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
    @androidx.compose.runtime.Composable
    public static final void CountdownCard(@org.jetbrains.annotations.NotNull
    java.lang.String title, long targetDate, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> titleIcon, boolean showProgressBar, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onCountdownFinished) {
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
    @androidx.compose.runtime.Composable
    public static final void DeadlineCountdown(@org.jetbrains.annotations.NotNull
    java.lang.String title, long targetDate, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, boolean showProgressBar, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onCountdownFinished) {
    }
    
    /**
     * Example usage with a hardcoded date (for preview and testing)
     */
    @androidx.compose.runtime.Composable
    public static final void ExampleDeadlineCountdown(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void CountdownCardPreview() {
    }
}