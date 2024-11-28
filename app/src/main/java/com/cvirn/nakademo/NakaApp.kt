package com.cvirn.nakademo

import android.app.Application
import com.cvirn.local.di.localDataModule
import com.cvirn.nakademo.di.appModule
import com.cvirn.remote.di.remoteDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NakaApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NakaApp)
            modules(localDataModule, appModule, remoteDataModule)
        }
    }
}
