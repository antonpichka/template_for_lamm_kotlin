package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model

abstract class BaseModel protected constructor(val uniqueId: String) {
    abstract fun clone(): BaseModel

    abstract override fun toString(): String
}