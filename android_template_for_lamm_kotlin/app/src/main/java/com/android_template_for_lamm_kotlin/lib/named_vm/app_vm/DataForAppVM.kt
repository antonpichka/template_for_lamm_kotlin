package com.android_template_for_lamm_kotlin.lib.named_vm.app_vm

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import kotlinx.coroutines.Job

class DataForAppVM(isLoading: Boolean,
                   var enumRoutesUtility: EnumRoutesUtility,
                   var jobWFirstRequest: Job?,
                   private val isDarkTheme: Boolean) : BaseDataForNamed<EnumDataForAppVM>(isLoading)
{
    val startDestination: String = enumRoutesUtility.name

    override fun getEnumDataForNamed(): EnumDataForAppVM {
        if(isLoading) {
            return EnumDataForAppVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException() && isDarkTheme) {
            return EnumDataForAppVM.EXCEPTION_W_IS_DARK_THEME
        }
        if(exceptionController.isWhereNotEqualsNullParameterException() && !isDarkTheme) {
            return EnumDataForAppVM.EXCEPTION_W_IS_LIGHT_THEME
        }
        if(isDarkTheme) {
            return EnumDataForAppVM.SUCCESS_W_IS_DARK_THEME
        }
        return EnumDataForAppVM.SUCCESS_W_IS_LIGHT_THEME
    }

    override fun toString(): String {
        return "DataForAppVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "enumRoutesUtility: ${enumRoutesUtility.name}, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()}, " +
                "isDarkTheme: $isDarkTheme, " +
                "startDestination: $startDestination)"
    }
}