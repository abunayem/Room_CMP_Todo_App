package com.abunayem.roomcmp.di

import androidx.room.RoomDatabase
import com.abunayem.roomcmp.data.database.RoomDb
import com.abunayem.roomcmp.data.database.iosDatabaseBuilder
import org.koin.dsl.module

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


val iosDatabaseModule = module {
    single<RoomDatabase.Builder<RoomDb>> { iosDatabaseBuilder() }
}