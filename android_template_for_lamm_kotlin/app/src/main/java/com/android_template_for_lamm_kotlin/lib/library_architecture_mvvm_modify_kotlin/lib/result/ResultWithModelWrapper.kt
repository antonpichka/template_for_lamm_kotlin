package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.result

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.ExceptionController
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_exception.BaseException
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseModelWrapper

class ResultWithModelWrapper<T : BaseModelWrapper> private constructor(
    val modelWrapper: T?,
    val exceptionController: ExceptionController)
{
    companion object {
        fun success(modelWrapper: BaseModelWrapper): ResultWithModelWrapper<BaseModelWrapper> {
            return ResultWithModelWrapper(modelWrapper,ExceptionController.success())
        }

        fun exception(exception: BaseException): ResultWithModelWrapper<BaseModelWrapper> {
            return ResultWithModelWrapper(null, ExceptionController.exception(exception))
        }
    }
}