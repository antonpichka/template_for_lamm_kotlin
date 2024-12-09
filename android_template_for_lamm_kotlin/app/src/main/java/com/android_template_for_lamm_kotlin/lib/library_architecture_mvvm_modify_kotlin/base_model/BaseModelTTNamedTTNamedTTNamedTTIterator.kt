package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_model

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.CurrentModelWIndex
import kotlin.collections.ArrayList

abstract class BaseModelTTNamedTTNamedTTNamedTTIterator<T : BaseModel> {
    protected val listModelIterator: MutableList<T> = ArrayList()

    protected abstract fun currentModelWIndex(): CurrentModelWIndex<T>

    fun getSortedListModelFromListModelParameterListModelIterator(listModel: List<T>): List<T> {
        if(listModel.isEmpty()) {
            return ArrayList()
        }
        listModelIterator.addAll(listModel)
        val newListModel = ArrayList<T>()
        while(listModelIterator.isNotEmpty()) {
            val currentModelWIndex = currentModelWIndex()
            listModelIterator.removeAt(currentModelWIndex.index)
            newListModel.add(currentModelWIndex.currentModel)
        }
        return newListModel
    }
}