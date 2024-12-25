package com.android_template_for_lamm_kotlin.named_vm.app_vm

import io.github.antonpichka.lamm.base_data_for_named.BaseDataForNamed
import kotlinx.coroutines.Job

class DataForAppVM(isLoading: Boolean,
                   var jobWFirstRequest: Job?,
                   private val isDarkTheme: Boolean) : BaseDataForNamed<EnumDataForAppVM>(isLoading)
{
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
                "jobWFirstRequest: ${jobWFirstRequest.toString()}, " +
                "isDarkTheme: $isDarkTheme)"
    }
}