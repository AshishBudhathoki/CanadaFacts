package com.demo.aboutcanada.fragments

import android.os.Build
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.demo.aboutcanada.R
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoFragment
import com.google.common.truth.Truth.assertThat
import kotlinx.android.synthetic.main.fragment_canada_info.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class CanadaInfoFragmentTest {


    @Test
    fun `validate recycler list shown`() {
        val scenario =
            launchFragment<CanadaInfoFragment>(Bundle(), R.style.Theme_MaterialComponents)
        scenario.onFragment { fragment ->
            val repoListView =
                fragment.rvCanadaInfo
            assertThat(repoListView).isNotNull()
            assertThat(repoListView?.isVisible)
        }

    }

    @Test
    fun `validate toolBarTitle is shown`() {
        val scenario =
            launchFragment<CanadaInfoFragment>(Bundle(), R.style.Theme_MaterialComponents)
        scenario.onFragment { fragment ->
            val toolbarTitle =
                fragment.toolbarTitle
            assertThat(toolbarTitle).isNotNull()
            assertThat(toolbarTitle?.isVisible)
        }
    }
}