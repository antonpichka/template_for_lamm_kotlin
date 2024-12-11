package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_named_state

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed

class DefaultState<T : Enum<T>, Y : BaseDataForNamed<T>>(
    private val dataForNamed: Y) : BaseNamedState<T, Y>()
{
    override fun getDataForNamed(): Y {
        return this.dataForNamed
    }

    override fun dispose() {
    }
}