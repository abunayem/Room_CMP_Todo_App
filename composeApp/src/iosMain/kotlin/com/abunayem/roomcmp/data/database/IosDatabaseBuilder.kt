package com.abunayem.roomcmp.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


fun iosDatabaseBuilder(): RoomDatabase.Builder<RoomDb> {

    val dbFile = documentDirectory() + "/room_db.db"

    return Room.databaseBuilder<RoomDb>(
        dbFile
    )

}


@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {

    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )

    return requireNotNull(documentDirectory?.path)
}