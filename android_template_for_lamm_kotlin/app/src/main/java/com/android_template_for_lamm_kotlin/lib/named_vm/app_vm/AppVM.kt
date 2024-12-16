package com.android_template_for_lamm_kotlin.lib.named_vm.app_vm

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.TempCacheProvider
import com.android_template_for_lamm_kotlin.lib.named_stream_w_state.MutableStateFlowStreamWState
import com.android_template_for_lamm_kotlin.lib.named_utility.AndroidThemeUtility
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.lib.named_utility.KeysTempCacheProviderUtility
import kotlinx.coroutines.*

class AppViewModel(dataForAppVM: DataForAppVM) : ViewModel() {
    // NamedStreamWState
    val namedStreamWState = MutableStateFlowStreamWState(dataForAppVM)

    // TempCacheProvider
    private val tempCacheProvider = TempCacheProvider()

    // ModelWrapperRepository

    // NamedUtility

    init {
        listensNamedTempCacheProvider()
    }

    override fun onCleared() {
        super.onCleared()
        namedStreamWState
            .getDataForNamed()
            .jobWFirstRequest
            ?.cancel()
    }


    fun firstRequest() {
        namedStreamWState.getDataForNamed().jobWFirstRequest = viewModelScope.launch {
            delay(1000)
            namedStreamWState
                .getDataForNamed()
                .isLoading = false
            namedStreamWState.notifyStreamDataForNamed()
        }
    }

    private fun listensNamedTempCacheProvider() {
        tempCacheProvider.listenNamed(KeysTempCacheProviderUtility.ENUM_ROUTES_UTILITY) { event: Any ->
            callbackYYImplementListenerEnumRoutesUtilityWTempCacheProvider(event)
        }
    }

    private fun callbackYYImplementListenerEnumRoutesUtilityWTempCacheProvider(event: Any) {
        val enumRoutesUtility = event as EnumRoutesUtility
        namedStreamWState
            .getDataForNamed()
            .enumRoutesUtility = enumRoutesUtility
        namedStreamWState
            .notifyStreamDataForNamed()
    }
}

@SuppressLint("NewApi")
@Composable
fun AppVM(dataWAppVM: DataForAppVM) {
    val viewModel = AppViewModel(dataWAppVM)
    viewModel
        .namedStreamWState
        .ListenStreamDataForNamed()
    LaunchedEffect(Unit) {
        viewModel.firstRequest()
    }
    val dataWNamed = viewModel
        .namedStreamWState
        .getDataForNamed()
    when (dataWNamed.getEnumDataForNamed()) {
        EnumDataForAppVM.IS_LOADING -> {
            MaterialTheme(
                typography = AndroidThemeUtility.typography,
                content = {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black
                    ) {
                    }
                }
            )
        }
        EnumDataForAppVM.EXCEPTION -> {
            MaterialTheme(
                typography = AndroidThemeUtility.typography,
                content = {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Text(
                            text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}"
                        )
                    }
                }
            )
        }
        EnumDataForAppVM.IS_DYNAMIC_DARK_COLOR_SCHEME -> {
            MaterialTheme(
                colorScheme = dynamicDarkColorScheme(LocalContext.current),
                typography = AndroidThemeUtility.typography,
                content = {
                    val navController = rememberNavController()
                    LaunchedEffect(dataWNamed.enumRoutesUtility) {
                        navController.navigate(dataWNamed.enumRoutesUtility) {
                            popUpTo(EnumRoutesUtility.MAIN_VM.name) { inclusive = true }
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = EnumRoutesUtility.MAIN_VM.name
                    )
                    {
                        composable(EnumRoutesUtility.MAIN_VM.name) { MainVM() }
                    }
                }
            )
        }
        EnumDataForAppVM.IS_DYNAMIC_LIGHT_COLOR_SCHEME -> {
            MaterialTheme(
                colorScheme = dynamicLightColorScheme(LocalContext.current),
                typography = AndroidThemeUtility.typography,
                content = {
                    val navController = rememberNavController()
                    LaunchedEffect(dataWNamed.enumRoutesUtility) {
                        navController.navigate(dataWNamed.enumRoutesUtility) {
                            popUpTo(EnumRoutesUtility.MAIN_VM.name) { inclusive = true }
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = EnumRoutesUtility.MAIN_VM.name
                    )
                    {
                        composable(EnumRoutesUtility.MAIN_VM.name) { MainVM() }
                    }
                }
            )
        }
        EnumDataForAppVM.IS_DARK_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.darkColorScheme,
                typography = AndroidThemeUtility.typography,
                content = {
                    val navController = rememberNavController()
                    LaunchedEffect(dataWNamed.enumRoutesUtility) {
                        navController.navigate(dataWNamed.enumRoutesUtility) {
                            popUpTo(EnumRoutesUtility.MAIN_VM.name) { inclusive = true }
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = EnumRoutesUtility.MAIN_VM.name
                    )
                    {
                        composable(EnumRoutesUtility.MAIN_VM.name) { MainVM() }
                    }
                }
            )
        }
        EnumDataForAppVM.IS_LIGHT_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.lightColorScheme,
                typography = AndroidThemeUtility.typography,
                content = {
                    val navController = rememberNavController()
                    LaunchedEffect(dataWNamed.enumRoutesUtility) {
                        navController.navigate(dataWNamed.enumRoutesUtility) {
                            popUpTo(EnumRoutesUtility.MAIN_VM.name) { inclusive = true }
                        }
                    }
                    NavHost(
                        navController = navController,
                        startDestination = EnumRoutesUtility.MAIN_VM.name
                    )
                    {
                        composable(EnumRoutesUtility.MAIN_VM.name) { MainVM() }
                    }
                }
            )
        }
    }
}