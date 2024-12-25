package com.android_template_for_lamm_kotlin.model_wrapper_repository.example_wrapper_repository

import io.github.antonpichka.lamm.base_model_wrapper_repository.BaseModelWrapperRepository
import io.github.antonpichka.lamm.result.ResultWithModelWrapper

open class ExampleWrapperRepository : BaseModelWrapperRepository() {
    override fun dispose() {
    }

    suspend fun getExampleParameterUnknown(): ResultWithModelWrapper {
        throw Exception()
    }
}