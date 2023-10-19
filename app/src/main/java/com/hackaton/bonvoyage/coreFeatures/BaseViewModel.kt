package com.hackaton.bonvoyage.coreFeatures

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel: ViewModel(), CoroutineScope {
    private val scopeJob: Job = SupervisorJob()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    override val coroutineContext: CoroutineContext = scopeJob + Dispatchers.Main + errorHandler

    private fun handleError(throwable: Throwable) {
        Log.i("http errors", "${throwable.message} --- basevm")
    }

    protected open fun processHttpError() { }

    protected open fun processNetworkError() {}

    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}