package com.android_template_for_lamm_kotlin.lib.model.example.example_wrapper

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseModelWrapper
import com.android_template_for_lamm_kotlin.lib.model.example.Example

open class ExampleWrapper(listObject: List<Any>) : BaseModelWrapper(listObject) {
    override fun createModel(): Example {
        return Example(listObject[0] as String)
    }
}