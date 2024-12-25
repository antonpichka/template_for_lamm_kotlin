package com.android_template_for_lamm_kotlin.model.example

import io.github.antonpichka.lamm.base_model.BaseListModel

open class ListExample<T : Example>(listModel: MutableList<T>) : BaseListModel<T>(listModel) {
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