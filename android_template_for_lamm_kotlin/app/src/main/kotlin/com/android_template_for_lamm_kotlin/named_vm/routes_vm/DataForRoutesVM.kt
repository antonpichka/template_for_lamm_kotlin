package com.android_template_for_lamm_kotlin.named_vm.routes_vm

import com.android_template_for_lamm_kotlin.named_utility.EnumRoutesUtility
import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
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