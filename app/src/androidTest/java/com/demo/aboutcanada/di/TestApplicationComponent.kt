package com.demo.aboutcanada.di

import android.content.Context
import com.demo.aboutcanada.di.modules.ActivityBuilderModule
import com.demo.aboutcanada.di.modules.ApplicationModule
import com.demo.aboutcanada.di.modules.FragmentModule
import com.demo.aboutcanada.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        FakeApiModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        FragmentModule::class
    ]
)
interface TestApplicationComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): TestApplicationComponent
    }

}