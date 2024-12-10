package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_model

abstract class BaseListModelWrapper protected constructor(protected val listsListObject: List<List<Any>>) {
    abstract fun createListModel(): BaseListModel<BaseModel>
}