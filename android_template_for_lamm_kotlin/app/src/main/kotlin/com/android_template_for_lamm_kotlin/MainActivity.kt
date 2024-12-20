package com.android_template_for_lamm_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import com.android_template_for_lamm_kotlin.named_vm.app_vm.AppVM
import com.android_template_for_lamm_kotlin.named_vm.app_vm.AppViewModel
import com.android_template_for_lamm_kotlin.named_vm.app_vm.DataForAppVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppVM(
                viewModel = AppViewModel(
                    dataWNamed = DataForAppVM(
                        isLoading = true,
                        jobWFirstRequest = null,
                        isDarkTheme = isSystemInDarkTheme()
                    )
                ),
            )
        }
    }
}