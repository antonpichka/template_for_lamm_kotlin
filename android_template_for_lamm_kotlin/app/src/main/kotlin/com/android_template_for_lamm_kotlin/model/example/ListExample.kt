package com.android_template_for_lamm_kotlin.model.example

import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model.BaseListModel
import com.android_template_for_lamm_kotlin.library_architecture_mvvm_modify_kotlin.base_model.BaseModel

open class ListExample<T : Example>(listModel: MutableList<T>) : BaseListModel(listModel) {
    @Suppress("UNCHECKED_CAST")
    override fun clone(): ListExample<T> {
        val newListModel = mutableListOf<T>()
        for(itemModel: T in listModel) {
            newListModel.add(itemModel.clone() as T)
        }
        return ListExample(newListModel)
    }

    override fun toString(): String {
        var strListModel = "\n"
        for(itemModel: T in listModel) {
            strListModel += "$itemModel,\n"
        }
        return "ListExample(listModel: [$strListModel])"
    }
}