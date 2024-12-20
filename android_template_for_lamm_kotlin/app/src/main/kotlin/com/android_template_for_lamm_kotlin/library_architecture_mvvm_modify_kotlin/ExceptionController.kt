package com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_exception.BaseException

class ExceptionController private constructor(
    private val exception: BaseException?)
{
    companion object {
        fun success(): ExceptionController {
            return ExceptionController(null)
        }

        fun exception(exception: BaseException): ExceptionController {
            return ExceptionController(exception)
        }
    }

    override fun toString(): String {
        if(exception == null) {
            return "ExceptionController(exception: null)"
        }
        return "ExceptionController(exception: $exception)"
    }

    fun getKeyParameterException(): String {
        return exception?.key ?: ""
    }

    fun isWhereNotEqualsNullParameterException(): Boolean {
        return exception != null
    }
}