package com.android_template_for_lamm_kotlin.named_utility

import com.android_template_for_lamm_kotlin.model_wrapper_repository.example_wrapper_repository.ExampleWrapperRepository

class FactoryModelWrapperRepositoryUtility private constructor() {
    companion object {
        fun getExampleWrapperRepository(): ExampleWrapperRepository {
            return ExampleWrapperRepository()
        }
    }
}