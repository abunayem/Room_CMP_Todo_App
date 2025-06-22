package com.abunayem.roomcmp.di

import androidx.room.RoomDatabase
import com.abunayem.roomcmp.data.database.androidDatabaseBuilder
import com.abunayem.roomcmp.data.database.RoomDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


val androidDatabaseModule = module {
    single<RoomDatabase.Builder<RoomDb>> { androidDatabaseBuilder(androidContext()) }
}