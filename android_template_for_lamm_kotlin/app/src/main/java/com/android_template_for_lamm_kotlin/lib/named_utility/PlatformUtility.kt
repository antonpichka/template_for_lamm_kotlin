package com.android_template_for_lamm_kotlin.lib.named_utility

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun PlatformUtility(
    callbackWMobile: @Composable () -> Unit,
    callbackWTablet: @Composable () -> Unit)
{
    BoxWithConstraints {
        when {
            maxWidth >= 600.dp -> callbackWTablet()
            else -> callbackWMobile()
        }
    }
}