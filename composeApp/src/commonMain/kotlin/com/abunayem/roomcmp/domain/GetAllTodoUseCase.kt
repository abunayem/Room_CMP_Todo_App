package com.abunayem.roomcmp.domain

import com.abunayem.roomcmp.data.model.TodoItem
import com.abunayem.roomcmp.data.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */
class GetAllTodoUseCase(private val todoRepository: TodoRepository) {

    operator fun invoke(): Flow<List<TodoItem>?> {
        return todoRepository.getAllTodos()
    }
}