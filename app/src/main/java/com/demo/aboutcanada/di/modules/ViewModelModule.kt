package com.demo.aboutcanada.di.modules

import androidx.lifecycle.ViewModelProvider
import com.demo.aboutcanada.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}