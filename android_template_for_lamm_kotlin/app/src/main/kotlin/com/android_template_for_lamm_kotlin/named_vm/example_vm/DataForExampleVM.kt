package com.android_template_for_lamm_kotlin.named_vm.example_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForExampleVM(isLoading: Boolean,
                       var jobWFirstRequest: Job?) : BaseDataForNamed<EnumDataForExampleVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForExampleVM {
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