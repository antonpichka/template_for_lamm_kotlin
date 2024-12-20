package com.android_template_for_lamm_kotlin.named_utility

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class AndroidThemeUtility private constructor() {
    companion object {
        val lightColorScheme: ColorScheme = lightColorScheme(
            // Purple40
            primary = Color(0xFF6650a4),
            // PurpleGrey40
            secondary = Color(0xFF625b71),
            // Pink40
            tertiary = Color(0xFF7D5260)
        )

        val darkColorScheme: ColorScheme = darkColorScheme(
            // Purple80
            primary = Color(0xFFD0BCFF),
            // PurpleGrey80
            secondary = Color(0xFFCCC2DC),
            // Pink80
            tertiary = Color(0xFFEFB8C8)
        )

        val typography: Typography = Typography(
            titleLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            ),
            labelSmall = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            )
        )
    }
}