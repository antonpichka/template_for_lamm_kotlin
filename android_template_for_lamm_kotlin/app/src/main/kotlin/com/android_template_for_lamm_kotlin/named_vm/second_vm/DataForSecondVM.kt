package com.android_template_for_lamm_kotlin.named_vm.second_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForSecondVM(isLoading: Boolean,
                      var jobWFirstRequest: Job?) : BaseDataForNamed<EnumDataForSecondVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForSecondVM {
        if(isLoading) {
            return EnumDataForSecondVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForSecondVM.EXCEPTION
        }
        return EnumDataForSecondVM.SUCCESS
    }

    override fun toString(): String {
        return "DataForSecondVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()})"
    }
}