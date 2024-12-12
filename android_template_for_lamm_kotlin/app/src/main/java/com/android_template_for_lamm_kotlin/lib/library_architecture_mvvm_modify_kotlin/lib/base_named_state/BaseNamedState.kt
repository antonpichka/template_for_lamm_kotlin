package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_named_state

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.IDispose
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed

abstract class BaseNamedState<T : Enum<T>, Y : BaseDataForNamed<T>> protected constructor() : IDispose {
    abstract fun getDataForNamed(): Y
}