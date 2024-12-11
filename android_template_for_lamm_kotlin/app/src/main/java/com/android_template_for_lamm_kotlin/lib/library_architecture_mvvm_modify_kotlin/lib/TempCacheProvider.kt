package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.named_service.IterationService
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.named_service.TempCacheService

class TempCacheProvider {
    private val tempCacheService: TempCacheService = TempCacheService.instance
    private val iteration: Int = IterationService.instance.newValueParameterIteration()

    fun <T> getNamed(keyTempCache: String, defaultValue: T): T {
        return tempCacheService.getNamed(keyTempCache,defaultValue)
    }

    fun dispose(listKeyTempCache: List<String>) {
        tempCacheService.dispose(listKeyTempCache,iteration)
    }

    fun listenNamed(keyTempCache: String, callback: (event: Any) -> Unit) {
        tempCacheService.listenNamed(keyTempCache,callback,iteration)
    }

    fun update(keyTempCache: String, value: Any) {
        tempCacheService.update(keyTempCache,value)
    }

    fun updateWNotify(keyTempCache: String, value: Any) {
        tempCacheService.updateWNotify(keyTempCache,value)
    }

    fun delete(keyTempCache: String) {
        tempCacheService.delete(keyTempCache)
    }
}