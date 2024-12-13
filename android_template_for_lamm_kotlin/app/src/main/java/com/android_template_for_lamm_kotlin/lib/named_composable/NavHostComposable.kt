package com.android_template_for_lamm_kotlin.lib.named_composable

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.lib.named_vm.main_vm.DataForMainVM
import com.android_template_for_lamm_kotlin.lib.named_vm.main_vm.MainVM
import com.android_template_for_lamm_kotlin.lib.named_vm.second_vm.DataForSecondVM
import com.android_template_for_lamm_kotlin.lib.named_vm.second_vm.SecondVM

@Composable
fun NavHostComposable(
    navController: NavHostController,
    startDestination: String,
    enumRoutesUtility: EnumRoutesUtility)
{
    MainVM(
        dataWNamed = DataForMainVM(
            isLoading = true,
            jobWFirstRequest = null
        ),
        callbackWNavigateToSecondVM = {}
    )
}