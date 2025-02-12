package com.juacie.viewsonic

import android.app.Application
import com.juacie.viewsonic.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

/**
 * 基本Application
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // 初始化 Koin
        startKoin {
            androidContext(this@App)
            modules(appModule) // 註冊模組
        }
    }
}