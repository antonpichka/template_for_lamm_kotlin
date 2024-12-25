package com.android_template_for_lamm_kotlin.named_vm.app_vm

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_template_for_lamm_kotlin.named_stream_w_state.MutableStateFlowStreamWState
import com.android_template_for_lamm_kotlin.named_utility.AndroidThemeUtility
import com.android_template_for_lamm_kotlin.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.named_utility.KeysTempCacheProviderUtility
import com.android_template_for_lamm_kotlin.named_vm.routes_vm.DataForRoutesVM
import com.android_template_for_lamm_kotlin.named_vm.routes_vm.RoutesVM
import com.android_template_for_lamm_kotlin.named_vm.routes_vm.RoutesViewModel
import io.github.antonpichka.lamm.TempCacheProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppViewModel(dataWNamed: DataForAppVM) : ViewModel() {
    // NamedStreamWState
    val namedStreamWState = MutableStateFlowStreamWState(dataWNamed)

    // TempCacheProvider
    private val tempCacheProvider = TempCacheProvider()

    // ModelWrapperRepository

    // NamedUtility

    override fun onCleared() {
        super.onCleared()
        tempCacheProvider.dispose(listOf(KeysTempCacheProviderUtility.ENUM_ROUTES_UTILITY))
        namedStreamWState
            .getDataForNamed()
            .jobWFirstRequest
            ?.cancel()
        namedStreamWState.dispose()
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
}

@SuppressLint("NewApi")
@Composable
fun AppVM(viewModel: AppViewModel) {
    val collectAsState by viewModel
        .namedStreamWState
        .stateFlow
        .collectAsState()
    // Coroutines for using animations and built-in composable functions
    // val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.firstRequest()
    }
    DisposableEffect(Unit) {
        onDispose {
        }
    }
    val dataWNamed = collectAsState.dataForNamed
    when (dataWNamed.getEnumDataForNamed()) {
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
                        text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}"
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
                        text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}"
                    )
                }
            }
        }
        EnumDataForAppVM.SUCCESS_W_IS_DARK_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.darkColorScheme,
                typography = AndroidThemeUtility.typography)
            {
                RoutesVM(
                    viewModel = RoutesViewModel(
                        dataWNamed = DataForRoutesVM(
                            isLoading = false,
                            jobWFirstRequest = null,
                            enumRoutesUtility = EnumRoutesUtility.MAIN_VM
                        )
                    )
                )
            }
        }
        EnumDataForAppVM.SUCCESS_W_IS_LIGHT_THEME -> {
            MaterialTheme(
                colorScheme = AndroidThemeUtility.lightColorScheme,
                typography = AndroidThemeUtility.typography)
            {
                RoutesVM(
                    viewModel = RoutesViewModel(
                        dataWNamed = DataForRoutesVM(
                            isLoading = false,
                            jobWFirstRequest = null,
                            enumRoutesUtility = EnumRoutesUtility.MAIN_VM
                        )
                    )
                )
            }
        }
    }
}