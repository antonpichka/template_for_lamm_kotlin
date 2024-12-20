package com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.result

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.ExceptionController
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_exception.BaseException
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model.BaseModelWrapper

class ResultWithModelWrapper<T : BaseModelWrapper> private constructor(
    val modelWrapper: T?,
    val exceptionController: ExceptionController
)
{
    companion object {
        fun success(modelWrapper: BaseModelWrapper): ResultWithModelWrapper<BaseModelWrapper> {
            return ResultWithModelWrapper(modelWrapper, ExceptionController.success())
        }

        fun exception(exception: BaseException): ResultWithModelWrapper<BaseModelWrapper> {
            return ResultWithModelWrapper(null, ExceptionController.exception(exception))
        }
    }
}