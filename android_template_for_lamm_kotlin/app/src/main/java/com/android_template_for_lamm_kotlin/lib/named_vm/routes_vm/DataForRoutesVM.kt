package com.android_template_for_lamm_kotlin.lib.named_vm.routes_vm

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForRoutesVM(isLoading: Boolean,
                      var jobWFirstRequest: Job?) : BaseDataForNamed<EnumDataForRoutesVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForRoutesVM{
        if(isLoading) {
            return EnumDataForRoutesVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForRoutesVM.EXCEPTION
        }
        return EnumDataForRoutesVM.MAIN_VM
    }

    override fun toString(): String {
        return "DataForRoutesVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()})"
    }
}