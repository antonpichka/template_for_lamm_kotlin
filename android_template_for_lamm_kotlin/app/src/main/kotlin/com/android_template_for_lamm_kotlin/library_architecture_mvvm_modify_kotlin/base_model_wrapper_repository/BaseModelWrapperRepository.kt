package com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model_wrapper_repository

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.IDispose

abstract class BaseModelWrapperRepository protected constructor() : IDispose {
    protected fun getSafeValueFromMapAndKeyAndDefaultValue(map: Map<String,Any>, key: String, defaultValue: Any): Any {
        try {
            if(map.containsKey(key)) {
                return map[key] ?: ""
            }
            return defaultValue
        } catch (_: Exception) {
            return defaultValue
        }
    }
}