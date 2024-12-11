package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_named_stream_w_state

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.IDispose
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed

abstract class BaseNamedStreamWState<T : Enum<T>, Y : BaseDataForNamed<T>> protected constructor() :
    IDispose {
    abstract fun getDataForNamed(): Y

    abstract fun listenStreamDataForNamedFromCallback(callback: (event: Y) -> Unit)

    abstract fun notifyStreamDataForNamed()
}