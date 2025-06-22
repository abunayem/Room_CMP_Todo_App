package com.abunayem.roomcmp.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


fun desktopDatabaseBuilder(): RoomDatabase.Builder<RoomDb> {

    val dbFile = File(System.getProperty("java.io.tmpdir"), "room_db.db")

    return Room.databaseBuilder(
        dbFile.absolutePath
    )
}