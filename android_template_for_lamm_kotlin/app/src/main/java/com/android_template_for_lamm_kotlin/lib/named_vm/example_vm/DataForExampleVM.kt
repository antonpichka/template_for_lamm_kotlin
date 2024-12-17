package com.android_template_for_lamm_kotlin.lib.named_vm.example_vm

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForExampleVM(isLoading: Boolean,
                       var jobWFirstRequest: Job?) : BaseDataForNamed<EnumDataForExampleVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForExampleVM{
        if(isLoading) {
            return EnumDataForExampleVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForExampleVM.EXCEPTION
        }
        return EnumDataForExampleVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForExampleVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()})"
    }
}