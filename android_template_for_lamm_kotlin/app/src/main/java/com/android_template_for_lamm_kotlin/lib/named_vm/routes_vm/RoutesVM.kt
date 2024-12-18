package com.android_template_for_lamm_kotlin.lib.named_vm.routes_vm

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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RoutesViewModel(dataWNamed: DataForRoutesVM) : ViewModel() {
    // NamedStreamWState
    val namedStreamWState = MutableStateFlowStreamWState(dataWNamed)

    // TempCacheProvider
    private val tempCacheProvider = TempCacheProvider()

    // ModelWrapperRepository

    // NamedUtility

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
}

@Composable
fun RoutesVM(dataWNamed: DataForRoutesVM) {
    val viewModel = RoutesViewModel(dataWNamed)
    val collectAsState by viewModel
        .namedStreamWState
        .stateFlow
        .collectAsState()
    LaunchedEffect(Unit) {
        viewModel.firstRequest()
    }
    val dataWNamedFirst = collectAsState.dataForNamed
    when (dataWNamedFirst.getEnumDataForNamed()) {
        EnumDataForRoutesVM.IS_LOADING -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
            }
        }
        EnumDataForRoutesVM.EXCEPTION -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Text(
                    text = "Exception: ${dataWNamedFirst.exceptionController.getKeyParameterException()}"
                )
            }
        }
        EnumDataForRoutesVM.MAIN_VM -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Text(
                    text = "Success"
                )
            }
        }
        EnumDataForRoutesVM.SECOND_VM -> {

        }
    }
}