package com.abunayem.roomcmp.di

import org.koin.core.context.startKoin

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


fun initKoin() {
    startKoin {
        modules(iosDatabaseModule, sharedModule)
    }
}