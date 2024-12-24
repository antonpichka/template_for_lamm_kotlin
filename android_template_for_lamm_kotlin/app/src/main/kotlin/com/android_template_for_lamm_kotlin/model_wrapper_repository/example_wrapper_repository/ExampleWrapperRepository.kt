package com.android_template_for_lamm_kotlin.model_wrapper_repository.example_wrapper_repository

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model_wrapper_repository.BaseModelWrapperRepository
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.result.ResultWithModelWrapper
import com.android_template_for_lamm_kotlin.model.example.example_wrapper.ExampleWrapper
import com.android_template_for_lamm_kotlin.model.example.example_wrapper.ListExampleWrapper

open class ExampleWrapperRepository : BaseModelWrapperRepository() {
    override fun dispose() {
    }

    suspend fun getExampleParameterUnknown(): ResultWithModelWrapper {
        throw Exception()
    }
}