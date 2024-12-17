package com.android_template_for_lamm_kotlin.lib

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.lib.named_vm.app_vm.AppVM
import com.android_template_for_lamm_kotlin.lib.named_vm.app_vm.DataForAppVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppVM(
                dataWNamed = DataForAppVM(
                    isLoading = true,
                    enumRoutesUtility = EnumRoutesUtility.MAIN_VM,
                    jobWFirstRequest = null,
                    isDarkTheme = isSystemInDarkTheme(),
                    sdkIntByVersionByBuild = Build.VERSION.SDK_INT,
                    sByVersionCodesByBuild = Build.VERSION_CODES.S)
            )
        }
    }
}