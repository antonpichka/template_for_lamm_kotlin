package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_exception

class LocalException(
    thisClass: Any,
    val enumGuilty: EnumGuilty,
    key: String,
    val exceptionMessage: String = "") : BaseException(thisClass, "LocalException", key)
{
    init {
        debugPrintExceptionParametersThisClassAndExceptionClass()
    }

    override fun toString(): String {
        return "LocalException(enumGuilty: ${this.enumGuilty.name}, " +
                "key: ${this.key}, " +
                "exceptionMessage (optional): ${this.exceptionMessage})"
    }
}