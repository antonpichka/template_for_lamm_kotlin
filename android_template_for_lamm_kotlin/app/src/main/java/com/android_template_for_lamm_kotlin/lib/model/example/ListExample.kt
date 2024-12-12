package com.android_template_for_lamm_kotlin.lib.model.example

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseListModel
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseModel

open class ListExample(listModel: MutableList<BaseModel>) : BaseListModel(listModel) {
    override fun clone(): ListExample {
        val newListModel = mutableListOf<BaseModel>()
        for(itemModel: Example in listModel<Example>()) {
            newListModel.add(itemModel.clone())
        }
        return ListExample(newListModel)
    }

    override fun toString(): String {
        var strListModel = "\n"
        for(itemModel: Example in listModel<Example>()) {
            strListModel += "$itemModel,\n"
        }
        return "ListExample(listModel: [$strListModel])"
    }
}