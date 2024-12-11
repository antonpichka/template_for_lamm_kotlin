package com.android_template_for_lamm_kotlin.named_test_main

import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.TempCacheProvider
import com.android_template_for_lamm_kotlin.lib.library_architecture_mvvm_modify_kotlin.lib.named_service.IterationService
import org.junit.Assert.assertEquals
import org.junit.Test

class IterationServiceTestMain    {
    @Test
    fun iterationServiceTestMain() {
        TempCacheProvider()
        TempCacheProvider()
        TempCacheProvider()
        TempCacheProvider()
        TempCacheProvider()
        assertEquals(5, IterationService.instance.newValueParameterIteration())
    }
}