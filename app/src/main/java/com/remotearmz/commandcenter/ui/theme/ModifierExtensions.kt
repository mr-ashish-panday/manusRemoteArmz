package com.remotearmz.commandcenter.ui.theme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

fun Modifier.clickableWithRipple(
    enabled: Boolean = true,
    onClick: () -> Unit
) = this.then(
    Modifier.clickable(
        enabled = enabled,
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple()
    )
)

fun Modifier.backgroundWithRoundedCorners(
    color: Color = MaterialTheme.colorScheme.surface,
    cornerRadius: Dp = 8.dp
) = this.then(
    Modifier
        .clip(RoundedCornerShape(cornerRadius))
        .background(color)
)

@Composable
fun Modifier.animateContentSize() = this.then(
    androidx.compose.animation.animateContentSize()
)

@Composable
fun Modifier.alpha(alpha: Float) = this.then(
    Modifier.alpha(alpha)
)

@Composable
fun Modifier.surfaceColorAtElevation(elevation: Dp) = this.then(
    Modifier.background(
        MaterialTheme.colorScheme.surfaceColorAtElevation(elevation)
    )
)
