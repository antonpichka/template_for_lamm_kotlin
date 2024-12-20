package com.android_template_for_lamm_kotlin.named_vm.routes_vm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.TempCacheProvider
import com.android_template_for_lamm_kotlin.named_stream_w_state.MutableStateFlowStreamWState
import com.android_template_for_lamm_kotlin.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.named_utility.KeysTempCacheProviderUtility
import com.android_template_for_lamm_kotlin.named_vm.main_vm.DataForMainVM
import com.android_template_for_lamm_kotlin.named_vm.main_vm.MainVM
import com.android_template_for_lamm_kotlin.named_vm.main_vm.MainViewModel
import com.android_template_for_lamm_kotlin.named_vm.second_vm.DataForSecondVM
import com.android_template_for_lamm_kotlin.named_vm.second_vm.SecondVM
import com.android_template_for_lamm_kotlin.named_vm.second_vm.SecondViewModel
import kotlinx.coroutines.launch

class RoutesViewModel(dataWNamed: DataForRoutesVM) : ViewModel() {
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
        tempCacheProvider.dispose(listOf())
        namedStreamWState
            .getDataForNamed()
            .jobWFirstRequest
            ?.cancel()
        namedStreamWState.dispose()
    }

    fun firstRequest() {
        namedStreamWState.getDataForNamed().jobWFirstRequest = viewModelScope.launch {
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

@Composable
fun RoutesVM(viewModel: RoutesViewModel) {
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
        EnumDataForRoutesVM.MAIN_VM -> {
            MainVM(
                viewModel = MainViewModel(
                    dataWNamed = DataForMainVM(
                        isLoading = true,
                        jobWFirstRequest = null,
                    )
                ),
            )
        }
        EnumDataForRoutesVM.SECOND_VM -> {
            SecondVM(
                viewModel = SecondViewModel(
                    dataWNamed = DataForSecondVM(
                        isLoading = true,
                        jobWFirstRequest = null
                    )
                ),
            )
        }
    }
}