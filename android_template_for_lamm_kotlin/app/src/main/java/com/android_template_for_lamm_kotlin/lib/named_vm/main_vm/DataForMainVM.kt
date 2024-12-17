package com.android_template_for_lamm_kotlin.lib.named_vm.main_vm

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForMainVM(isLoading: Boolean,
                    var jobWFirstRequest: Job?) : BaseDataForNamed<EnumDataForMainVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForMainVM {
        if(isLoading) {
            return EnumDataForMainVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForMainVM.EXCEPTION
        }
        return EnumDataForMainVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForMainVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()})"
    }
}