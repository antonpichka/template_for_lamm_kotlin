package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_data_for_named

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.ExceptionController

abstract class BaseDataForNamed<T : Enum<T>>(
    val isLoading: Boolean)
{
    val exceptionController: ExceptionController = ExceptionController.success()

    abstract fun getEnumDataForNamed(): T

    abstract override fun toString(): String
}