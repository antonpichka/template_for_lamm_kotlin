package com.android_template_for_lamm_kotlin.named_vm.main_vm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android_template_for_lamm_kotlin.named_composable.PlatformComposable
import com.android_template_for_lamm_kotlin.named_stream_w_state.MutableStateFlowStreamWState
import com.android_template_for_lamm_kotlin.named_utility.EnumRoutersUtility
import com.android_template_for_lamm_kotlin.named_utility.KeysTempCacheProviderUtility
import io.github.antonpichka.lamm.TempCacheProvider
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
        tempCacheProvider.dispose(listOf())
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

    fun onClickYYGoForward() {
        tempCacheProvider.updateWNotify(
            KeysTempCacheProviderUtility.ENUM_ROUTERS_UTILITY,
            EnumRoutersUtility.SECOND_VM)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainVM(viewModel: MainViewModel) {
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
        EnumDataForMainVM.IS_LOADING -> {
            PlatformComposable(
                callbackWTablet = {

                }
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "MainVM")
                            }
                        )
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                            }
                        ) {
                            Text(text = "X")
                        }
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Text(text = "Loading")
                    }
                }
            }
        }
        EnumDataForMainVM.EXCEPTION -> {
            PlatformComposable(
                callbackWTablet = {

                }
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "MainVM")
                            }
                        )
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                            }
                        ) {
                            Text(text = "X")
                        }
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Text(
                            text = "Exception: ${dataWNamed.exceptionController.getKeyParameterException()}"
                        )
                    }
                }
            }
        }
        EnumDataForMainVM.SUCCESS -> {
            PlatformComposable(
                callbackWTablet = {

                }
            ) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "MainVM")
                            }
                        )
                    },
                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                            }
                        ) {
                            Text(text = "X")
                        }
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier.padding(paddingValues)
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
    }
}