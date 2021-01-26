package com.demo.aboutcanada.features.canadaInfo

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.demo.aboutcanada.commons.Loading
import com.demo.aboutcanada.commons.Success
import com.demo.aboutcanada.commons.UiStateViewModel
import com.demo.aboutcanada.mapper.toPresentation
import com.demo.aboutcanada.model.CanadaInfoUiModel
import com.demo.aboutcanada.model.ToolbarTitleUiModel
import com.demo.domain.usecase.GetCanadaInfoUseCase
import com.demo.domain.usecase.GetToolbarTitleUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class CanadaInfoViewModel @Inject constructor(
    private val getCanadaInfoUseCase: GetCanadaInfoUseCase,
    private val getToolbarTitleUseCase: GetToolbarTitleUseCase
) : UiStateViewModel() {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var searchJob: Job? = null

    val getCanadaInfoResults: LiveData<List<CanadaInfoUiModel>>
        get() = getCanadaInfo

    private var getCanadaInfo: MutableLiveData<List<CanadaInfoUiModel>> =
        MutableLiveData()

    val getToolbarTitle: LiveData<ToolbarTitleUiModel>
        get() = getToolbarTitleFromSource

    private var getToolbarTitleFromSource: MutableLiveData<ToolbarTitleUiModel> =
        MutableLiveData()

    fun executeTrendingRepositorySearch(forceRefresh: Boolean = false) {
        _uiState.value = Loading
        viewModelScope.launch(handler) {
            getCanadaInfoUseCase(forceRefresh).collect { canadaInfoList ->
                getCanadaInfo.value = canadaInfoList.map { canadaInfo ->
                    canadaInfo.toPresentation()
                }
            }
            _uiState.value = Success
            getToolbarTitleFromSource.value = getToolbarTitleUseCase.invoke().toPresentation()
        }
    }

    override fun onDestroy(lifecycleOwner: LifecycleOwner) {
        searchJob?.cancel()
    }
}