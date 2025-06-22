package com.abunayem.roomcmp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.abunayem.roomcmp.data.dao.TodoDao
import com.abunayem.roomcmp.data.model.TodoItem

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


@Database(entities = [TodoItem::class], version = 1, exportSchema = true)

@ConstructedBy(AppDatabaseConstructor::class)
abstract class RoomDb : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}


@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<RoomDb> {
    override fun initialize(): RoomDb
}