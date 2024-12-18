package com.android_template_for_lamm_kotlin.lib.named_vm.app_vm

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.TempCacheProvider
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
        EnumDataForAppVM.EXCEPTION_W_IS_DARK_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.darkColorScheme,
                typography = AndroidThemeUtility.typography)
            {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(
                        text = "Exception: ${dataWNamedFirst.exceptionController.getKeyParameterException()}"
                    )
                }
            }
        }
        EnumDataForAppVM.EXCEPTION_W_IS_LIGHT_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.lightColorScheme,
                typography = AndroidThemeUtility.typography)
            {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(
                        text = "Exception: ${dataWNamedFirst.exceptionController.getKeyParameterException()}"
                    )
                }
            }
        }
        EnumDataForAppVM.SUCCESS_W_IS_DARK_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.darkColorScheme,
                typography = AndroidThemeUtility.typography)
            {
            }
        }
        EnumDataForAppVM.SUCCESS_W_IS_LIGHT_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.lightColorScheme,
                typography = AndroidThemeUtility.typography)
            {
            }
        }
    }
}