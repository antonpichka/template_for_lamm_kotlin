package com.android_template_for_lamm_kotlin.lib.named_vm.app_vm

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_data_for_named.BaseDataForNamed
import com.android_template_for_lamm_kotlin.lib.named_utility.EnumRoutesUtility
import kotlinx.coroutines.Job

class DataForAppVM(isLoading: Boolean,
                   var enumRoutesUtility: EnumRoutesUtility,
                   var jobWFirstRequest: Job?,
                   private val isDarkTheme: Boolean,
                   private val sdkIntByVersionByBuild: Int,
                   private val sByVersionCodesByBuild: Int) : BaseDataForNamed<EnumDataForAppVM>(isLoading)
{
    val startDestination: String = enumRoutesUtility.name

    override fun getEnumDataForNamed(): EnumDataForAppVM {
        if(isLoading) {
            return EnumDataForAppVM.IS_LOADING
        }
        if(exceptionController.isWhereNotEqualsNullParameterException()) {
            return EnumDataForAppVM.EXCEPTION
        }
        if(sdkIntByVersionByBuild >= sByVersionCodesByBuild && isDarkTheme) {
            return EnumDataForAppVM.IS_DYNAMIC_DARK_COLOR_SCHEME
        }
        if(sdkIntByVersionByBuild >= sByVersionCodesByBuild && !this.isDarkTheme) {
            return EnumDataForAppVM.IS_DYNAMIC_LIGHT_COLOR_SCHEME
        }
        if(isDarkTheme) {
            return EnumDataForAppVM.IS_DARK_THEME
        }
        return EnumDataForAppVM.IS_LIGHT_THEME
    }

    override fun toString(): String {
        return "DataForAppVM(isLoading: $isLoading, " +
                "exceptionController: $exceptionController, " +
                "enumRoutesUtility: ${enumRoutesUtility.name}, " +
                "jobWFirstRequest: ${jobWFirstRequest.toString()}, " +
                "isDarkTheme: $isDarkTheme, " +
                "sdkIntByVersionByBuild: $sdkIntByVersionByBuild, " +
                "sByVersionCodesByBuild: $sByVersionCodesByBuild)"
    }
}