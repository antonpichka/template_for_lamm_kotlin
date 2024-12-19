package com.android_template_for_lamm_kotlin.lib.named_vm.routes_vm

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import kotlinx.coroutines.Job

class DataForRoutesVM(isLoading: Boolean,
                      var jobWFirstRequest: Job?,
                      var enumRoutesUtility: EnumRoutesUtility) : BaseDataForNamed<EnumDataForRoutesVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForRoutesVM {
        if(enumRoutesUtility == EnumRoutesUtility.SECOND_VM) {
            return EnumDataForRoutesVM.SECOND_VM
        }
        return EnumDataForRoutesVM.MAIN_VM
    }

    override fun toString(): String {
        return "DataForRoutesVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()}, " +
                "enumRoutesUtility: ${enumRoutesUtility.name})"
    }
}