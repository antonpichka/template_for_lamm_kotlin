package com.android_template_for_lamm_kotlin.named_composable

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun PlatformComposable(
    callbackWTablet: @Composable () -> Unit,
    content: @Composable () -> Unit)
{
    BoxWithConstraints {
        when {
            maxWidth >= 600.dp -> callbackWTablet()
            else -> content()
        }
    }
}