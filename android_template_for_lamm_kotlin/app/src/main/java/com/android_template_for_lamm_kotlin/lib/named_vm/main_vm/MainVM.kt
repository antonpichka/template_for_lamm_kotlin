package com.android_template_for_lamm_kotlin.lib.named_vm.main_vm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import com.android_template_for_lamm_kotlin.lib.named_utility.KeysTempCacheProviderUtility
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(dataWNamed: DataForMainVM) : ViewModel() {
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

    fun onClickYYGoForward() {
        tempCacheProvider.updateWNotify(KeysTempCacheProviderUtility.ENUM_ROUTES_UTILITY,EnumRoutesUtility.SECOND_VM)
    }
}

@Composable
fun MainVM(dataWNamed: DataForMainVM) {
    val viewModel = MainViewModel(dataWNamed)
    val collectAsState by viewModel
        .namedStreamWState
        .stateFlow
        .collectAsState()
    LaunchedEffect(Unit) {
        viewModel.firstRequest()
    }
    val dataWNamedFirst = collectAsState.dataForNamed
    when (dataWNamedFirst.getEnumDataForNamed()) {
        EnumDataForMainVM.IS_LOADING -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
            }
        }
        EnumDataForMainVM.EXCEPTION -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Text(
                    text = "Exception: ${dataWNamedFirst.exceptionController.getKeyParameterException()}"
                )
            }
        }
        EnumDataForMainVM.SUCCESS -> {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Button(
                    onClick = {
                        viewModel.onClickYYGoForward()
                    }
                ) {
                    Text(text = "Go Forward")
                }
                Text(
                    text = "MainVM"
                )
            }
        }
    }
}