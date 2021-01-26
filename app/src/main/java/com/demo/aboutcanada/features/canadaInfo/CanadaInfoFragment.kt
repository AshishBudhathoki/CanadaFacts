package com.demo.aboutcanada.features.canadaInfo

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.demo.aboutcanada.R
import com.demo.aboutcanada.base.BaseFragment
import com.demo.aboutcanada.commons.Error
import com.demo.aboutcanada.commons.Loading
import com.demo.aboutcanada.commons.Success
import com.demo.aboutcanada.model.CanadaInfoUiModel
import com.demo.aboutcanada.model.ToolbarTitleUiModel
import com.demo.aboutcanada.utils.hide
import com.demo.aboutcanada.utils.initRecyclerViewWithLineDecoration
import com.demo.aboutcanada.utils.show
import com.demo.aboutcanada.utils.showSnackbar
import kotlinx.android.synthetic.main.fragment_canada_info.*
import kotlinx.android.synthetic.main.layout_error_status_notifier.*
import kotlinx.android.synthetic.main.layout_status_loading.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import javax.inject.Inject

class CanadaInfoFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val canadaInfoViewModel: CanadaInfoViewModel by viewModels { viewModelFactory }

    override fun layoutId(): Int = R.layout.fragment_canada_info

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    private fun initComponents() {
        fetchCanadaInfo()
        observeUiState()
        observeApiResults()
        addListeners()
    }

    private fun addListeners() {
        swipeRepoRefresh.setOnRefreshListener {
            fetchCanadaInfo(true)
            swipeRepoRefresh.isRefreshing = false
        }
        lookUpButton.setOnClickListener {
            fetchCanadaInfo()
        }
    }


    private fun observeApiResults() {
        canadaInfoViewModel.getCanadaInfoResults.observe(viewLifecycleOwner, Observer {
            displayApiResults(it)
        })

        canadaInfoViewModel.getToolbarTitle.observe(viewLifecycleOwner, Observer {
            displayToolbarTitle(it)
        })

    }

    private fun displayToolbarTitle(it: ToolbarTitleUiModel) {
        toolbarTitle.text = it.toolbarTitle
    }


    private fun observeUiState() {
        canadaInfoViewModel.uiState.observe(viewLifecycleOwner, {
            when (it) {
                is Loading -> displayLoadingState()
                is Success -> hideLoadingState()
                is Error -> displayErrorState(it.error)
            }
        })
    }

    private fun displayErrorState(error: Throwable) {
        hideLoadingState()
        layoutError.show()
        showSnackbar(rvCanadaInfo, "${error.message}")
    }

    private fun hideLoadingState() {
        rvCanadaInfo.show()
        layoutError.hide()
        containerShimmer.hide()
        containerShimmer.stopShimmer()
    }

    private fun displayLoadingState() {
        rvCanadaInfo.hide()
        layoutError.hide()
        containerShimmer.show()
        containerShimmer.showShimmer(true)

    }

    private fun fetchCanadaInfo(forceRefresh: Boolean = false) {
        canadaInfoViewModel.executeTrendingRepositorySearch(forceRefresh)
    }

    private fun displayApiResults(canadaInfoList: List<CanadaInfoUiModel>) {
        val canadaInfoAdapter = CanadaInfoAdapter(canadaInfoList)

        if (canadaInfoList.isNotEmpty()) {
            if (layoutError.isVisible) {
                layoutError.hide()
            }
            rvCanadaInfo.apply {
                adapter = canadaInfoAdapter
                canadaInfoAdapter.stateRestorationPolicy =
                    RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
                initRecyclerViewWithLineDecoration(activity?.baseContext!!)
                rvCanadaInfo.recycledViewPool.setMaxRecycledViews(0, 0);
            }
        } else displayNoSearchResults()

    }

    private fun displayNoSearchResults() {
        showSnackbar(
            rvCanadaInfo,
            getString(R.string.label_no_times)
        )
    }
}