package br.com.navigationpoc.marketpoc

import android.app.Application
import br.com.navigationpoc.marketpoc.di.daoModule
import br.com.navigationpoc.marketpoc.di.testeDatabaseModule
import br.com.navigationpoc.marketpoc.di.uiModule
import br.com.navigationpoc.marketpoc.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
                listOf(
                    testeDatabaseModule,
                    daoModule,
                    uiModule,
                    viewModelModule
                )
            )
        }
    }
}