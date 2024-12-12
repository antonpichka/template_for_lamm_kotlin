package com.android_template_for_lamm_kotlin.lib.model_wrapper_repository.example_wrapper_repository

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model_wrapper_repository.BaseModelWrapperRepository
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.result.ResultWithModelWrapper
import com.android_template_for_lamm_kotlin.lib.model.example.example_wrapper.ExampleWrapper
import com.android_template_for_lamm_kotlin.lib.model.example.example_wrapper.ListExampleWrapper

open class ExampleWrapperRepository<T : ExampleWrapper, Y : ListExampleWrapper> : BaseModelWrapperRepository() {
    override fun dispose() {
    }

    suspend fun getExampleParameterUnknown(): ResultWithModelWrapper<T> {
        throw Exception()
    }
}