package com.android_template_for_lamm_kotlin.named_stream_w_state

import com.android_template_for_lamm_kotlin.named_utility.WrapperDataWNamedWNamedStreamWStateUtility
import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import io.github.antonpichka.lamm.base_exception.EnumGuilty
import io.github.antonpichka.lamm.base_exception.LocalException
import io.github.antonpichka.lamm.base_named_stream_w_state.BaseNamedStreamWState
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