package com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.named_service

class IterationService private constructor() {
    companion object {
        val instance = IterationService()
    }

    private var iteration: Int = -1

    fun newValueParameterIteration(): Int {
        iteration++
        return iteration
    }
}