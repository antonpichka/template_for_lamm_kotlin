package com.android_template_for_lamm_kotlin.model.example.example_wrapper

import io.github.antonpichka.lamm.base_model.BaseModelWrapper
import io.github.antonpichka.lamm.base_model.BaseModel
import com.android_template_for_lamm_kotlin.model.example.Example

open class ExampleWrapper(listObject: List<Any>) : BaseModelWrapper(listObject) {
    @Suppress("UNCHECKED_CAST")
    override fun<T : BaseModel> createModel(): T {
        return Example(listObject[0] as String) as T
    }
}