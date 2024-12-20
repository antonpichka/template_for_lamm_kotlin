package com.android_template_for_lamm_kotlin.model.example.example_wrapper

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model.BaseModelWrapper
import com.android_template_for_lamm_kotlin.model.example.Example

open class ExampleWrapper(listObject: List<Any>) : BaseModelWrapper(listObject) {
    override fun createModel(): Example {
        return Example(listObject[0] as String)
    }
}