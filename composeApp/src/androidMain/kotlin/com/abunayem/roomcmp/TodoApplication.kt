package com.abunayem.roomcmp

import android.app.Application
import com.abunayem.roomcmp.di.androidDatabaseModule
import com.abunayem.roomcmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */
class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TodoApplication)
            modules(androidDatabaseModule, sharedModule)
        }
    }
}