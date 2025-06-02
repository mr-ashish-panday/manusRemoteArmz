package com.remotearmz.commandcenter.ui.theme

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

// Animation constants
private const val ITEM_ANIMATION_DELAY = 50L
private const val FADE_IN_DURATION = 400
private const val SCALE_ANIMATION_DURATION = 150

// Animation specs
val itemAppearAnimation = fadeIn(
    animationSpec = tween(FADE_IN_DURATION)
) + slideInVertically(
    initialOffsetY = { it / 2 },
    animationSpec = tween(FADE_IN_DURATION)
)

// Extension function for list item animations
fun Modifier.animateItemAppearance(index: Int) = composed {
    var isVisible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = (index * ITEM_ANIMATION_DELAY).toInt(),
            easing = FastOutSlowInEasing
        ),
        label = "fade_animation_$index"
    )
    
    val offsetY by animateDpAsState(
        targetValue = if (isVisible) 0.dp else 20.dp,
        animationSpec = tween(
            durationMillis = 400,
            delayMillis = (index * ITEM_ANIMATION_DELAY).toInt(),
            easing = FastOutSlowInEasing
        ),
        label = "slide_animation_$index"
    )
    
    LaunchedEffect(Unit) {
        isVisible = true
    }
    
    this
        .graphicsLayer {
            translationY = offsetY.value * density
            this.alpha = alpha
        }
}

// Extension function for press scale effect
fun Modifier.scaleOnPress(
    onPress: () -> Unit,
    scale: Float = 0.95f
): Modifier = composed {
    var isPressed by remember { mutableStateOf(false) }
    val scaleValue by animateFloatAsState(
        targetValue = if (isPressed) scale else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale_animation"
    )
    
    this
        .scale(scaleValue)
        .clickable(
            onClick = {
                isPressed = true
                onPress()
                // Reset pressed state after animation
                LaunchedEffect(Unit) {
                    delay(SCALE_ANIMATION_DURATION.toLong())
                    isPressed = false
                }
            }
        )
}

// Extension function for FAB animation
@Composable
fun Modifier.animateFloatingActionButton(
    isVisible: Boolean = true,
    onPress: () -> Unit
): Modifier = composed {
    var isPressed by remember { mutableStateOf(false) }
    
    // Scale animation for press effect
    val pressScale by animateFloatAsState(
        targetValue = if (isPressed) 0.9f else 1f,
        animationSpec = spring(
            dampingRatio = 0.6f,
            stiffness = 1000f
        ),
        label = "fab_press_scale"
    )
    
    // Bounce animation on appear
    val bounceScale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0.8f,
        animationSpec = spring(
            dampingRatio = 0.4f,
            stiffness = 800f
        ),
        label = "fab_bounce_scale"
    )
    
    this
        .graphicsLayer {
            scaleX = if (isVisible) pressScale * bounceScale else 0f
            scaleY = if (isVisible) pressScale * bounceScale else 0f
        }
        .clickable(
            onClick = {
                isPressed = true
                onPress()
                // Reset pressed state after animation
                LaunchedEffect(Unit) {
                    delay(SCALE_ANIMATION_DURATION.toLong())
                    isPressed = false
                }
            }
        )
}
