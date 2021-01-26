package com.demo.aboutcanada.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.aboutcanada.di.ViewModelKey
import com.demo.aboutcanada.di.factory.ViewModelFactory
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(CanadaInfoViewModel::class)
    abstract fun bindCanadaInfoViewModel(canadaInfoViewModel: CanadaInfoViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}