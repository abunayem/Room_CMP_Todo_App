package com.abunayem.roomcmp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.abunayem.roomcmp.data.model.TodoItem
import com.abunayem.roomcmp.ui.viewmodel.SharedViewModel
import org.koin.compose.viewmodel.koinViewModel

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel = koinViewModel<SharedViewModel>()

    var showAddDialog by remember { mutableStateOf(false) }
    var showUpdateDialog by remember { mutableStateOf(false) }

    var selectedTodo by remember { mutableStateOf<TodoItem?>(null) }

    val todoList by viewModel.getAllTodos().collectAsStateWithLifecycle(initialValue = null)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar {
                Box(modifier = modifier.fillMaxSize()) {
                    FloatingActionButton(
                        modifier = modifier.align(Alignment.CenterEnd),
                        onClick = { showAddDialog = true },
                        content = {
                            Icon(
                                modifier = modifier.size(MaterialTheme.typography.headlineLarge.fontSize.value.dp),
                                imageVector = Icons.Filled.Add,
                                contentDescription = null,
                            )
                        },
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            }
        }

    ) { paddingValues ->

        Surface {
            Box(contentAlignment = Alignment.Center) {
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    itemsIndexed(items = todoList.orEmpty()) { index, item ->
                        ListItem(
                            modifier = modifier
                                .fillMaxSize()
                                .padding(2.dp),
                            colors = ListItemDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            leadingContent = {
                                Text(
                                    text = (index + 1).toString(),
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            },
                            headlineContent = {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.headlineLarge
                                )
                            },
                            trailingContent = {
                                Row {
                                    TextButton(
                                        onClick = { viewModel.deleteTodo(item) }
                                    ) {
                                        Icon(Icons.Default.Delete, contentDescription = null)
                                    }
                                    TextButton(
                                        onClick = {
                                            selectedTodo = item
                                            showUpdateDialog = true
                                        }
                                    ) {
                                        Icon(Icons.Default.Edit, contentDescription = null)
                                    }
                                }
                            }
                        )

                    }
                }

                if (showAddDialog) {
                    AddTodoDialog(
                        onDismiss = { showAddDialog = false },
                        onConfirm = viewModel.insertTodo
                    )
                }

                if (showUpdateDialog && selectedTodo != null) {
                    selectedTodo?.let {
                        UpdateTodoDialog(
                            todoItem = it,
                            onDismiss = { showUpdateDialog = false },
                            onConfirm = viewModel.updateTodo
                        )
                    }
                }
            }
        }

    }
}