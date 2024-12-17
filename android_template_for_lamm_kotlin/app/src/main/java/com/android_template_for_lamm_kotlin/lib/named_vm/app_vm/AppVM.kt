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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.TempCacheProvider
import com.android_template_for_lamm_kotlin.lib.named_composable.NavHostComposable
import com.android_template_for_lamm_kotlin.lib.named_stream_w_state.MutableStateFlowStreamWState
import com.android_template_for_lamm_kotlin.lib.named_utility.AndroidThemeUtility
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.lib.named_utility.KeysTempCacheProviderUtility
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppViewModel(dataWNamed: DataForAppVM) : ViewModel() {
    // NamedStreamWState
    val namedStreamWState = MutableStateFlowStreamWState(dataWNamed)

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
        namedStreamWState
            .getDataForNamed()
            .enumRoutesUtility = event as EnumRoutesUtility
        namedStreamWState
            .notifyStreamDataForNamed()
    }
}

@SuppressLint("NewApi")
@Composable
fun AppVM(dataWNamed: DataForAppVM) {
    val viewModel = AppViewModel(dataWNamed)
    val collectAsState by viewModel
        .namedStreamWState
        .stateFlow
        .collectAsState()
    LaunchedEffect(Unit) {
        viewModel.firstRequest()
    }
    val dataWNamedFirst = collectAsState.dataForNamed
    when (dataWNamedFirst.getEnumDataForNamed()) {
        EnumDataForAppVM.IS_LOADING -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
            }
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
                            text = "Exception: ${dataWNamedFirst.exceptionController.getKeyParameterException()}"
                        )
                    }
                }
            )
        }
        EnumDataForAppVM.IS_DYNAMIC_DARK_COLOR_SCHEME -> {
            NavHostComposable(
                startDestination = dataWNamedFirst.startDestination,
                enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
            )
           /* MaterialTheme(
                colorScheme = dynamicDarkColorScheme(LocalContext.current),
                typography = AndroidThemeUtility.typography,
                content = {
                    NavHostComposable(
                        startDestination = dataWNamedFirst.startDestination,
                        enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
                    )
                }
            )*/
        }
        EnumDataForAppVM.IS_DYNAMIC_LIGHT_COLOR_SCHEME -> {
            NavHostComposable(
                startDestination = dataWNamedFirst.startDestination,
                enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
            )
            /*MaterialTheme(
                colorScheme = dynamicLightColorScheme(LocalContext.current),
                typography = AndroidThemeUtility.typography,
                content = {
                    NavHostComposable(
                        startDestination = dataWNamedFirst.startDestination,
                        enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
                    )
                }
            )*/
        }
        EnumDataForAppVM.IS_DARK_THEME -> {
            NavHostComposable(
                startDestination = dataWNamedFirst.startDestination,
                enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
            )
            /*MaterialTheme(
                colorScheme = AndroidThemeUtility.darkColorScheme,
                typography = AndroidThemeUtility.typography,
                content = {
                    NavHostComposable(
                        startDestination = dataWNamedFirst.startDestination,
                        enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
                    )
                }
            )*/
        }
        EnumDataForAppVM.IS_LIGHT_THEME -> {
            NavHostComposable(
                startDestination = dataWNamedFirst.startDestination,
                enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
            )
            /*MaterialTheme(
                colorScheme = AndroidThemeUtility.lightColorScheme,
                typography = AndroidThemeUtility.typography,
                content = {
                    NavHostComposable(
                        startDestination = dataWNamedFirst.startDestination,
                        enumRoutesUtility = dataWNamedFirst.enumRoutesUtility
                    )
                }
            )*/
        }
    }
}