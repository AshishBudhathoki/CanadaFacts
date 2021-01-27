package com.demo.aboutcanada.di.modules

import com.demo.aboutcanada.di.modules.canadaInfo.CanadaInfoModule
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {
    @ContributesAndroidInjector(modules = [CanadaInfoModule::class])
    abstract fun bindCanadaInfoFragment(): CanadaInfoFragment
}