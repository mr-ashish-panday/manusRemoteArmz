package com.remotearmz.commandcenter.ui.theme

import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Fade-in animation for items in a list
fun Modifier.fadeInListAnimation(index: Int): Modifier = composed {
    var isVisible by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay((index * 50).toLong())
        isVisible = true
    }
    
    this
        .graphicsLayer {
            alpha = if (isVisible) 1f else 0f
            translationY = if (isVisible) 0f else 20f
        }
        .animateContentSize()
}

// Shimmer effect for loading states
@Composable
fun Modifier.shimmerLoadingAnimation(
    widthOfShadowBrush: Int = 500,
    angle: Float = 270f,
    durationMillis: Int = 1000,
): Modifier {
    val shimmerColors = listOf(
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f),
    )
    
    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
                delayMillis = 0
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_animation"
    )
    
    return this.then(
        Modifier.background(
            brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(translateAnim.value - widthOfShadowBrush, 0f),
                end = Offset(translateAnim.value, 0f)
            )
        )
    )
}

// Scale animation for FAB
@Composable
fun Modifier.scaleOnClick(
    scale: Float = 0.95f,
    duration: Int = 100,
    onAnimationEnd: () -> Unit = {}
): Modifier = composed {
    var isPressed by remember { mutableStateOf(false) }
    val scaleValue by animateFloatAsState(
        targetValue = if (isPressed) scale else 1f,
        animationSpec = tween(durationMillis = duration),
        label = "scale_animation"
    )
    
    LaunchedEffect(isPressed) {
        if (isPressed) {
            delay(duration.toLong())
            isPressed = false
            onAnimationEnd()
        }
    }
    
    this.scale(scaleValue)
        .clickable { isPressed = true }
}

// Bounce animation for new items
@Composable
fun Modifier.bounceOnAppear(delay: Long = 0): Modifier = composed {
    var isVisible by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0.8f,
        animationSpec = spring(
            dampingRatio = 0.4f,
            stiffness = 800f
        ),
        label = "bounce_animation"
    )
    
    LaunchedEffect(Unit) {
        delay(delay)
        isVisible = true
    }
    
    this.scale(scale)
}

// Slide-in animation for list items
fun Modifier.slideInListAnimation(index: Int, initialOffsetX: Int = 100): Modifier = composed {
    var isVisible by remember { mutableStateOf(false) }
    
    LaunchedEffect(Unit) {
        delay((index * 50).toLong())
        isVisible = true
    }
    
    this.then(
        if (isVisible) {
            Modifier.animateContentSize()
        } else {
            Modifier
                .graphicsLayer { translationX = initialOffsetX.toFloat() }
                .alpha(0f)
        }
    )
}

// Combined fade and scale animation
@Composable
fun Modifier.fadeScaleIn(initialScale: Float = 0.8f): Modifier = composed {
    var isVisible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "fade_animation"
    )
    val scale by animateFloatAsState(
        targetValue = if (isVisible) 1f else initialScale,
        animationSpec = tween(durationMillis = 300),
        label = "scale_animation"
    )
    
    LaunchedEffect(Unit) {
        isVisible = true
    }
    
    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
            this.alpha = alpha
        }
}
