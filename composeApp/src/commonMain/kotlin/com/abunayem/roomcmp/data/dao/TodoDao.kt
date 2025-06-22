package com.abunayem.roomcmp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.abunayem.roomcmp.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */

@Dao
interface TodoDao {

    @Insert
    suspend fun insert(todoItem: TodoItem)

    @Update
    suspend fun update(todoItem: TodoItem)

    @Delete
    suspend fun delete(todoItem: TodoItem)

    @Query("SELECT * FROM TodoItem")
    fun getAllTodos(): Flow<List<TodoItem>>
}