package com.example.androidproject.app

import android.app.Application
import com.example.androidproject.data.di.dataModule
import com.example.androidproject.domain.di.domainModule
import com.example.androidproject.presenter.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(presenterModule, domainModule, dataModule))
        }
    }
}