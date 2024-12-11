package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.result

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.ExceptionController
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_exception.BaseException
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseListModelWrapper

class ResultWithListModelsWrapper<T : BaseListModelWrapper> private constructor(
    val listModelWrapper: T?,
    val exceptionController: ExceptionController)
{
    companion object {
        fun success(listModelWrapper: BaseListModelWrapper): ResultWithListModelsWrapper<BaseListModelWrapper> {
            return ResultWithListModelsWrapper(listModelWrapper,ExceptionController.success())
        }

        fun exception(exception: BaseException): ResultWithListModelsWrapper<BaseListModelWrapper> {
            return ResultWithListModelsWrapper(null, ExceptionController.exception(exception))
        }
    }
}