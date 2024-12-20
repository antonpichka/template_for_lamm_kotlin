package com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model

abstract class BaseModelWrapper protected constructor(protected val listObject: List<Any>) {
    abstract fun createModel(): BaseModel
}