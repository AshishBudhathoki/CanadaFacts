package com.demo.aboutcanada.viewmodels

import androidx.lifecycle.*
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoViewModel
import com.demo.aboutcanada.mapper.toPresentation
import com.demo.domain.model.CanadaInfo
import com.demo.domain.model.ToolbarTitle
import com.demo.domain.usecase.GetCanadaInfoUseCase
import com.demo.domain.usecase.GetToolbarTitleUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class CanadaInfoViewModelTest : BaseViewModelTest() {

    @Mock
    lateinit var candaInfoUseCaseGet: GetCanadaInfoUseCase

    @Mock
    lateinit var toolbarUseCase: GetToolbarTitleUseCase

    private lateinit var canadaInfoViewModel: CanadaInfoViewModel

    @Before
    fun setup() {
        canadaInfoViewModel = CanadaInfoViewModel(candaInfoUseCaseGet, toolbarUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun shouldReceiveSearchResults() {
        runBlockingTest {
            setMockAnswer()
            canadaInfoViewModel.executeTrendingRepositorySearch()
            canadaInfoViewModel.getCanadaInfoResults.observeOnce {
                Truth.assertThat(it)
                    .isEqualTo(SampleData.canadaInfo.map { repo -> repo.toPresentation() })
            }
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun shouldReceiveToolbarTitle() {
        runBlockingTest {
            setMockAnswer()
            canadaInfoViewModel.executeTrendingRepositorySearch()
            canadaInfoViewModel.getToolbarTitle.observeOnce {
                Truth.assertThat(it)
                    .isEqualTo(SampleData.toolBarTitle.map { repo -> repo.toPresentation() })
            }
        }
    }

    private suspend fun setMockAnswer() {
        BDDMockito.given(candaInfoUseCaseGet(false)).willReturn(flow {
            emit(SampleData.canadaInfo)
        })
    }
}

object SampleData {
    val canadaInfo = listOf(
        CanadaInfo(
            "Canada",
            "Sample Git Repo",
            "http://canada.png",

            )
    )
    val toolBarTitle = listOf(
        ToolbarTitle(
            "Canada",
        )
    )

}

fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
    val observer = OneTimeObserver(onChangeHandler)
    //Lifecycle owner and observer
    observe(observer, observer)
}

internal class OneTimeObserver<T>(private val handler: (T) -> Unit) : Observer<T>, LifecycleOwner {

    private val lifecycle = LifecycleRegistry(this)

    init {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun getLifecycle(): Lifecycle = lifecycle

    override fun onChanged(t: T) {
        handler(t)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

}
