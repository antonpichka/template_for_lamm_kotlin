package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.result

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.ExceptionController
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_exception.BaseException

class Result private constructor(
    val parameter: Any?,
    val exceptionController: ExceptionController)
{
    companion object {
        fun success(parameter: Any): Result {
            return Result(parameter,ExceptionController.success())
        }

        fun exception(exception: BaseException): Result {
            return Result(null, ExceptionController.exception(exception))
        }
    }
}