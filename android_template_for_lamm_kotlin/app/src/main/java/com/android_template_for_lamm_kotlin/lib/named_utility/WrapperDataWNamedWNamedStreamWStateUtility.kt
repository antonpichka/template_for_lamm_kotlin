package com.android_template_for_lamm_kotlin.lib.named_utility

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed

class WrapperDataWNamedWNamedStreamWStateUtility<T : Enum<T>, Y : BaseDataForNamed<T>>(val dataForNamed: Y, private var iteration: Int) {
    override fun toString(): String {
        return "WrapperDataWNamedWNamedStreamWStateUtility(dataForNamed: $dataForNamed, " +
                "iteration: $iteration)"
    }

    fun getParameterIteration(): Int {
        return iteration
    }

    fun incrementParameterIteration() {
        iteration++
    }
}