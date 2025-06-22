package com.abunayem.roomcmp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abunayem.roomcmp.data.model.TodoItem
import com.abunayem.roomcmp.domain.DeleteTodoUseCase
import com.abunayem.roomcmp.domain.GetAllTodoUseCase
import com.abunayem.roomcmp.domain.InsertTodoUseCase
import com.abunayem.roomcmp.domain.UpdateTodoUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */
class SharedViewModel(
    private val insertTodoUseCase: InsertTodoUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val getAllTodosUseCase: GetAllTodoUseCase,
) : ViewModel() {

    val insertTodo = fun(todoItem: TodoItem) {
        viewModelScope.launch {
            insertTodoUseCase(todoItem)
        }
    }

    val updateTodo = fun(todoItem: TodoItem) {
        viewModelScope.launch {
            updateTodoUseCase(todoItem)
        }
    }

    val deleteTodo = fun(todoItem: TodoItem) {
        viewModelScope.launch {
            deleteTodoUseCase(todoItem)
        }
    }

    val getAllTodos = fun(): Flow<List<TodoItem>?> {
        return getAllTodosUseCase()
    }
}