package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_exception.BaseException

class ExceptionController private constructor(
    private val exception: BaseException?)
{
    companion object {
        fun success(): ExceptionController {
            return ExceptionController(null)
        }

        fun exception(exception: BaseException?): ExceptionController {
            return ExceptionController(exception)
        }
    }

    override fun toString(): String {
        if(this.exception == null) {
            return "ExceptionController(exception: null)"
        }
        return "ExceptionController(exception: " + this.exception + ")"
    }

    fun getKeyParameterException(): String {
        return this.exception?.key ?: ""
    }

    fun isWhereNotEqualsNullParameterException(): Boolean {
        return this.exception != null
    }
}