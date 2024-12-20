package com.android_template_for_lamm_kotlin.model.example

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model.BaseModel

open class Example(uniqueId: String) : BaseModel(uniqueId) {
    override fun clone(): Example {
        return Example(uniqueId)
    }

    override fun toString(): String {
        return "Example(uniqueId: $uniqueId)"
    }
}