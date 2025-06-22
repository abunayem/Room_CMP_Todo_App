package com.abunayem.roomcmp.di

import com.abunayem.roomcmp.data.database.CreateDatabase
import com.abunayem.roomcmp.data.database.RoomDb
import com.abunayem.roomcmp.data.repository.TodoRepository
import com.abunayem.roomcmp.domain.DeleteTodoUseCase
import com.abunayem.roomcmp.domain.GetAllTodoUseCase
import com.abunayem.roomcmp.domain.InsertTodoUseCase
import com.abunayem.roomcmp.domain.UpdateTodoUseCase
import com.abunayem.roomcmp.ui.viewmodel.SharedViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */


val sharedModule = module {
    // Database
    single<RoomDb> { CreateDatabase(get()).getDatabase() }
    // Repositories
    single { TodoRepository(get()) }

    // UseCases
    single { InsertTodoUseCase(get()) }
    single { UpdateTodoUseCase(get()) }
    single { DeleteTodoUseCase(get()) }
    single { GetAllTodoUseCase(get()) }

    // ViewModels
    viewModelOf(::SharedViewModel)

}