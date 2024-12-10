package com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.named_service

class TempCacheService private constructor() {
    companion object {
        val instance = TempCacheService()
    }

    private val tempCache: MutableMap<String,Any> = mutableMapOf()
    private val tempCacheWStreams: MutableMap<String, MutableMap<Int, (event: Any) -> Unit>> = mutableMapOf()

    fun <T> getNamed(keyTempCache: String, defaultValue: T): T {
        if(!tempCache.containsKey(keyTempCache)) {
            return defaultValue
        }
        @Suppress("UNCHECKED_CAST")
        return tempCache[keyTempCache] as T
    }

    fun dispose(listKeyTempCache: List<String>, iteration: Int) {
        for(itemKeyTempCache in listKeyTempCache) {
           if(!tempCacheWStreams.containsKey(itemKeyTempCache)) {
               return
           }
           tempCacheWStreams[itemKeyTempCache]?.remove(iteration)
        }
    }

    fun listenNamed(keyTempCache: String, callback: (event: Any) -> Unit, iteration: Int) {
        if(!tempCacheWStreams.containsKey(keyTempCache)) {
            tempCacheWStreams[keyTempCache] = mutableMapOf()
            tempCacheWStreams[keyTempCache]?.set(iteration, callback)
            return
        }
        // HERE HERE HERE

    }
}