package com.android_template_for_lamm_kotlin.named_utility

import com.android_template_for_lamm_kotlin.model.example.example_wrapper.ExampleWrapper
import com.android_template_for_lamm_kotlin.model.example.example_wrapper.ListExampleWrapper
import com.android_template_for_lamm_kotlin.model_wrapper_repository.example_wrapper_repository.ExampleWrapperRepository

class FactoryModelWrapperRepositoryUtility private constructor() {
    companion object {
        fun getExampleWrapperRepository(): ExampleWrapperRepository<ExampleWrapper, ListExampleWrapper> {
            return ExampleWrapperRepository()
        }
    }
}