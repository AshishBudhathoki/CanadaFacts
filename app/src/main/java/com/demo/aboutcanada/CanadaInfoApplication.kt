package com.demo.aboutcanada

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDex
import com.demo.aboutcanada.di.AppComponent
import com.demo.aboutcanada.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class CanadaInfoApplication : Application(), HasAndroidInjector, HasSupportFragmentInjector {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    private val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
            .factory()
            .create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent().inject(this)
    }

    open fun getApplicationComponent(): AppComponent = appComponent

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

}