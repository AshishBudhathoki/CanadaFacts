package com.demo.aboutcanada

import com.demo.aboutcanada.di.AppComponent
import com.demo.aboutcanada.di.DaggerTestApplicationComponent


class CanadaInfoTestApplication : CanadaInfoApplication() {

    override fun onCreate() {
        super.onCreate()
        getApplicationComponent().inject(this)
    }

    override fun getApplicationComponent(): AppComponent {
        return DaggerTestApplicationComponent.factory()
            .create(applicationContext)
    }

}