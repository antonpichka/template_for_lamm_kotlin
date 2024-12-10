package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.result

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.ExceptionController
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_exception.BaseException
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_model.BaseModelWrapper

class ResultWithModelWrapper private constructor(
    val modelWrapper: BaseModelWrapper?,
    val exceptionController: ExceptionController)
{
    companion object {
        fun success(modelWrapper: BaseModelWrapper): ResultWithModelWrapper {
            return ResultWithModelWrapper(modelWrapper,ExceptionController.success())
        }

        fun exception(exception: BaseException): ResultWithModelWrapper {
            return ResultWithModelWrapper(null, ExceptionController.exception(exception))
        }
    }
}