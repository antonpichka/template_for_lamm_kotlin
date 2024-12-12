package com.android_template_for_lamm_kotlin.lib.named_vm.app_vm

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.android_template_for_lamm_kotlin.lib.named_utility.AndroidThemeUtility
import com.android_template_for_lamm_kotlin.lib.named_utility.PlatformUtility

@Composable
fun AppVM(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    callbackWContent: @Composable () -> Unit
) {
    PlatformUtility(
        callbackWMobile = {

        },
        callbackWTablet = {

        })
    // isDarkTheme to DataForNamed
    val colorScheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        isDarkTheme -> AndroidThemeUtility.darkColorScheme
        else -> AndroidThemeUtility.lightColorScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = callbackWContent,
        typography = AndroidThemeUtility.typography
    )
}