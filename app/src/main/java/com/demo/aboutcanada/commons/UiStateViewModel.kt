package com.demo.aboutcanada.commons

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler


/**
 * This view model is used to represent the current state of the UI
 */
abstract class UiStateViewModel : ViewModel() {

    val uiState: LiveData<UiState>
        get() = mutableLiveDataUiState

    protected var mutableLiveDataUiState = MutableLiveData<UiState>()

    protected val handler = CoroutineExceptionHandler { _, exception ->
        mutableLiveDataUiState.value = Error(exception)
    }

    abstract fun onDestroy(lifecycleOwner: LifecycleOwner)

}