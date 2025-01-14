package com.android_template_for_lamm_kotlin.named_vm.routers_vm

import com.android_template_for_lamm_kotlin.named_utility.EnumRoutersUtility
import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForRoutersVM(isLoading: Boolean,
                       var jobWFirstRequest: Job?,
                       var enumRoutersUtility: EnumRoutersUtility) : BaseDataForNamed<EnumDataForRoutersVM>(isLoading)
{
    override fun getEnumDataForNamed(): EnumDataForRoutersVM {
        if(enumRoutersUtility == EnumRoutersUtility.SECOND_VM) {
            return EnumDataForRoutersVM.SECOND_VM
        }
        return EnumDataForRoutersVM.MAIN_VM
    }

    override fun toString(): String {
        return "DataForRoutersVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()}, " +
                "enumRoutersUtility: ${enumRoutersUtility.name})"
    }
}