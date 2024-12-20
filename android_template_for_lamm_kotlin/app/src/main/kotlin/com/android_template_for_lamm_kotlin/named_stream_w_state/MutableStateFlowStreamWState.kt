package com.android_template_for_lamm_kotlin.named_stream_w_state

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_data_for_named.BaseDataForNamed
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_exception.EnumGuilty
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_exception.LocalException
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_named_stream_w_state.BaseNamedStreamWState
import com.android_template_for_lamm_kotlin.named_utility.WrapperDataWNamedWNamedStreamWStateUtility
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MutableStateFlowStreamWState<T : Enum<T>, Y : BaseDataForNamed<T>>(dataForNamed: Y) : BaseNamedStreamWState<T, Y>() {
    private val wrapperDataWNamedWNamedStreamWStateUtility: WrapperDataWNamedWNamedStreamWStateUtility<T, Y> = WrapperDataWNamedWNamedStreamWStateUtility(dataForNamed,0)
    private val mutableStateFlow: MutableStateFlow<WrapperDataWNamedWNamedStreamWStateUtility<T, Y>> = MutableStateFlow(
        WrapperDataWNamedWNamedStreamWStateUtility(dataForNamed,0)
    )
    val stateFlow: StateFlow<WrapperDataWNamedWNamedStreamWStateUtility<T, Y>> = mutableStateFlow
    private var isDispose: Boolean = false

    override fun getDataForNamed(): Y {
        return wrapperDataWNamedWNamedStreamWStateUtility.dataForNamed
    }

    override fun dispose() {
        if(isDispose) {
            return
        }
        isDispose = true
    }

    override fun listenStreamDataForNamedFromCallback(callback: (event: Y) -> Unit) {
        throw LocalException(
            this,
            EnumGuilty.DEVELOPER,
            "MutableStateFlowStreamWStateQQListenStreamDataWNamedWCallback",
            "Do not use this method to register a listener. Use 'stateFlow'")
    }

    override fun notifyStreamDataForNamed() {
        if(isDispose) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "MutableStateFlowStreamWStateQQNotifyStreamDataWNamed",
                "Already disposed of")
        }
        wrapperDataWNamedWNamedStreamWStateUtility.incrementParameterIteration()
        mutableStateFlow.value = WrapperDataWNamedWNamedStreamWStateUtility(
            wrapperDataWNamedWNamedStreamWStateUtility.dataForNamed,
            wrapperDataWNamedWNamedStreamWStateUtility.getParameterIteration()
        )
    }
}