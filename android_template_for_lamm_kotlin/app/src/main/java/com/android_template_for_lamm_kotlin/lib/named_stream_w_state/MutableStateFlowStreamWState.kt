package com.android_template_for_lamm_kotlin.lib.named_stream_w_state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_exception.EnumGuilty
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_exception.LocalException
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_named_stream_w_state.BaseNamedStreamWState
import kotlinx.coroutines.flow.MutableStateFlow

class MutableStateFlowStreamWState<T : Enum<T>, Y : BaseDataForNamed<T>>(
    private val dataForNamed: Y) : BaseNamedStreamWState<T, Y>()
{
    private var isDispose: Boolean = false
    private var mutableStateFlow: MutableStateFlow<Y>? = null

    override fun getDataForNamed(): Y {
        return dataForNamed
    }

    override fun dispose() {
        if(isDispose) {
            return
        }
        isDispose = true
        mutableStateFlow = null
    }

    override fun listenStreamDataForNamedFromCallback(callback: (event: Y) -> Unit) {
        throw LocalException(
            this,
            EnumGuilty.DEVELOPER,
            "MutableStateFlowStreamWStateQQListenStreamDataWNamedWCallback",
            "Do not use this method to register a listener. Use 'ListenStreamDataForNamed'")
    }

    override fun notifyStreamDataForNamed() {
        if(isDispose) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "MutableStateFlowStreamWStateQQNotifyStreamDataWNamed",
                "Already disposed of")
        }
        if (mutableStateFlow == null) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "MutableStateFlowStreamWStateQQNotifyStreamDataWNamed",
                "Stream has no listener")
        }
        mutableStateFlow?.value = dataForNamed
    }

    @Composable
    fun ListenStreamDataForNamed() {
        if(isDispose) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "MutableStateFlowStreamWStateQQListenStreamDataWNamed",
                "Already disposed of")
        }
        if(this.mutableStateFlow != null) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "MutableStateFlowStreamWStateQQListenStreamDataWNamed",
                "Duplicate")
        }
        mutableStateFlow = MutableStateFlow(dataForNamed)
        mutableStateFlow?.collectAsState()
    }
}