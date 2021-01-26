package com.demo.aboutcanada.di

import android.content.Context
import com.demo.aboutcanada.CanadaInfoApplication
import com.demo.aboutcanada.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Core Application Dagger Component
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ApiModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent {

    fun inject(app: CanadaInfoApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}