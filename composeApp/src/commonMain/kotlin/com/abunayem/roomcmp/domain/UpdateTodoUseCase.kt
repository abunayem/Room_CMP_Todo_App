package com.abunayem.roomcmp.domain

import com.abunayem.roomcmp.data.model.TodoItem
import com.abunayem.roomcmp.data.repository.TodoRepository

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */
class UpdateTodoUseCase(private val todoRepository: TodoRepository) {

    suspend operator fun invoke(todoItem: TodoItem) {
        todoRepository.updateTodo(todoItem)
    }
}