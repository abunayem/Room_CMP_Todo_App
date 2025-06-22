package com.abunayem.roomcmp.data.repository

import com.abunayem.roomcmp.data.database.RoomDb
import com.abunayem.roomcmp.data.model.TodoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */
class TodoRepository(private val  dataBase: RoomDb) {

    private val dispatcher = Dispatchers.IO


    suspend fun insertTodo(todoItem: TodoItem) {
        with(dispatcher) {
            dataBase.todoDao().insert(todoItem)
        }
    }

    suspend fun updateTodo(todoItem: TodoItem) {
        with(dispatcher) {
            dataBase.todoDao().update(todoItem)
        }
    }

    suspend fun deleteTodo(todoItem: TodoItem) {
        with(dispatcher) {
            dataBase.todoDao().delete(todoItem)
        }
    }


    fun getAllTodos(): Flow<List<TodoItem>?> {
        return dataBase.todoDao().getAllTodos()
    }
}