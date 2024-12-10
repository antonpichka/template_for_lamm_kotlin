package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_named_stream_w_state

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_data_for_named.BaseDataForNamed
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_exception.EnumGuilty
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_exception.LocalException

class DefaultStreamWState<T : Enum<T>, Y : BaseDataForNamed<T>>(
    private val dataForNamed: Y) : BaseNamedStreamWState<T, Y>()
{
    private var isDispose: Boolean = false
    private var callback: ((event: Y) -> Unit)? = null

    override fun getDataForNamed(): Y {
        return this.dataForNamed
    }

    override fun dispose() {
        if(this.isDispose) {
            return
        }
        this.isDispose = true
        this.callback = null
    }

    override fun listenStreamDataForNamedFromCallback(callback: (event: Y) -> Unit) {
        if(this.isDispose) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "DefaultStreamWStateQQListenStreamDataWNamedWCallback",
                "Already disposed of")
        }
        if(this.callback != null) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "DefaultStreamWStateQQListenStreamDataWNamedWCallback",
                "Duplicate");
        }
        this.callback = callback
    }

    override fun notifyStreamDataForNamed() {
        if(this.isDispose) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "DefaultStreamWStateQQNotifyStreamDataWNamed",
                "Already disposed of");
        }
        if (this.callback == null) {
            throw LocalException(
                this,
                EnumGuilty.DEVELOPER,
                "DefaultStreamWStateQQNotifyStreamDataWNamed",
                "Stream has no listener");
        }
        this.callback?.let { it(this.dataForNamed) }
    }
}