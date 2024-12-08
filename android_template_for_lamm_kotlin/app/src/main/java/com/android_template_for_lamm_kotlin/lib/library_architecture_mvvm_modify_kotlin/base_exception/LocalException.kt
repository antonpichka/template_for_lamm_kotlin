package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_exception

class LocalException(
    thisClass: Any,
    val enumGuilty: EnumGuilty,
    key: String,
    override val message: String = "") : BaseException(thisClass, "LocalException", key)
{
    init {
        debugPrintExceptionParametersThisClassAndExceptionClass()
    }

    override fun toString(): String {
        return "LocalException(enumGuilty: ${this.enumGuilty.name}, " +
                "key: ${this.key}, " +
                "message (optional): ${this.message})"
    }
}