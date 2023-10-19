package com.hackaton.bonvoyage

import android.app.Application
import android.content.Context
import com.hackaton.bonvoyage.coreDI.CoreModule
import com.hackaton.core_di.nameDeep
import com.hackaton.core_di.qualifiers.AppQualifiers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val appModule = module(createdAtStart = true) {
            single<Context>(nameDeep(AppQualifiers.APP_CONTEXT)) { this@App }
        }
        CoreModule.arrayModule.add(appModule)

        startKoin {
            androidContext(this@App)
            modules(CoreModule.arrayModule)
        }
    }
}