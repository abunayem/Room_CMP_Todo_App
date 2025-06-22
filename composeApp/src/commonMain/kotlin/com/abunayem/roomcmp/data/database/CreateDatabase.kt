package com.abunayem.roomcmp.data.database

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */
class CreateDatabase(private val builder: RoomDatabase.Builder<RoomDb>) {

    fun getDatabase(): RoomDb {
        return builder
            .fallbackToDestructiveMigration(dropAllTables = true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}