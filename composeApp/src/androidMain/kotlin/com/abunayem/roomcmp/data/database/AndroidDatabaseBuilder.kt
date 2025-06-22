package com.abunayem.roomcmp.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */

fun androidDatabaseBuilder(context: Context): RoomDatabase.Builder<RoomDb> {

    val dbFile = context.applicationContext.getDatabasePath("room_db.db")

    return Room.databaseBuilder(
        context,
        dbFile.absolutePath
    )
}