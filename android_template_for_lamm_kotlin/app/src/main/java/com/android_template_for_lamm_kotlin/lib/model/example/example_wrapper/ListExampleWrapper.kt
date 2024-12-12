package com.android_template_for_lamm_kotlin.lib.model.example.example_wrapper

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseListModelWrapper
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.base_model.BaseModel
import com.android_template_for_lamm_kotlin.lib.model.example.Example
import com.android_template_for_lamm_kotlin.lib.model.example.ListExample

open class ListExampleWrapper(listsListObject: List<List<Any>>) : BaseListModelWrapper(listsListObject) {
    override fun createListModel(): ListExample {
        val listModel = mutableListOf<BaseModel>()
        for(itemListObject: List<Any> in listsListObject) {
            listModel.add(Example(itemListObject[0] as String))
        }
        return ListExample(listModel)
    }
}