package com.demo.aboutcanada.di.modules

import com.demo.aboutcanada.base.BaseActivity
import com.demo.aboutcanada.di.ActivityScope
import com.demo.aboutcanada.di.modules.canadaInfo.CanadaInfoModule
import com.demo.aboutcanada.di.modules.canadaInfo.CanadaInfoRepositoryBindingModule
import com.demo.aboutcanada.features.canadaInfo.CanadaInfoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [CanadaInfoRepositoryBindingModule::class])
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [CanadaInfoModule::class])
    abstract fun provideCanadaInfoActivity(): CanadaInfoActivity
}