package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseModel

class CurrentModelWIndex<T : BaseModel>(
    val currentModel: T,
    val index: Int)