package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.CurrentModelWIndex

abstract class BaseModelTTNamedTTNamedTTNamedTTIterator<T : BaseModel> protected constructor() {
    protected val listModelIterator: MutableList<T> = mutableListOf()

    protected abstract fun currentModelWIndex(): CurrentModelWIndex<T>

    fun getSortedListModelFromListModelParameterListModelIterator(listModel: List<T>): List<T> {
        if(listModel.isEmpty()) {
            return mutableListOf()
        }
        listModelIterator.addAll(listModel)
        val newListModel = mutableListOf<T>()
        while(listModelIterator.isNotEmpty()) {
            val currentModelWIndex = currentModelWIndex()
            listModelIterator.removeAt(currentModelWIndex.index)
            newListModel.add(currentModelWIndex.currentModel)
        }
        return newListModel
    }
}