package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.base_model

abstract class BaseListModel<T : BaseModel> protected constructor(val listModel: MutableList<T>) {
    abstract fun clone(): BaseListModel<T>

    abstract override fun toString(): String

    fun sortingFromModelTTNamedTTNamedTTNamedTTIteratorParameterListModel(modelTTNamedTTNamedTTNamedTTIterator: BaseModelTTNamedTTNamedTTNamedTTIterator<T>) {
        val sortedListModelFromListModelParameterListModelIterator = modelTTNamedTTNamedTTNamedTTIterator.getSortedListModelFromListModelParameterListModelIterator(this.listModel)
        this.listModel
            .takeIf { it.isNotEmpty() }
            ?.clear()
        sortedListModelFromListModelParameterListModelIterator
            .takeIf { it.isNotEmpty() }
            .let { this.listModel.addAll(sortedListModelFromListModelParameterListModelIterator) }
    }

    fun insertFromNewModelParameterListModel(newModel: T) {
        this.listModel.add(newModel)
    }

    fun updateFromNewModelParameterListModel(newModel: T) {
        val indexOfFirst = this.listModel.indexOfFirst { it.uniqueId == newModel.uniqueId }
        if(indexOfFirst == -1) {
            return
        }
        this.listModel[indexOfFirst] = newModel
    }

    fun deleteFromUniqueIdByModelParameterListModel(uniqueIdByModel: String) {
        val indexOfFirst = this.listModel.indexOfFirst { it.uniqueId == uniqueIdByModel }
        if(indexOfFirst == -1) {
            return
        }
        this.listModel.removeAt(indexOfFirst)
    }

    fun insertListFromNewListModelParameterListModel(newListModel: List<T>) {
        this.listModel.addAll(newListModel)
    }

    fun updateListFromNewListModelParameterListModel(newListModel: List<T>) {
        for(newItemModel in newListModel) {
            val indexOfFirst = this.listModel.indexOfFirst { it.uniqueId == newItemModel.uniqueId }
            if(indexOfFirst == -1) {
                continue
            }
            this.listModel[indexOfFirst] = newItemModel
        }
    }

    fun deleteListFromNewListModelParameterListModel(newListModel: List<T>) {
        for(newItemModel in newListModel) {
            val indexOfFirst = this.listModel.indexOfFirst { it.uniqueId == newItemModel.uniqueId }
            if(indexOfFirst == -1) {
                continue
            }
            this.listModel.removeAt(indexOfFirst)
        }
    }
}