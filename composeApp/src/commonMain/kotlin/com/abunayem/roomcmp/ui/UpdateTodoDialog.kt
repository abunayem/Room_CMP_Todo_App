package com.abunayem.roomcmp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.abunayem.roomcmp.data.model.TodoItem

/**
 * Created by Abu Nayem on 22-Jun-25.
 * hmabns@gmail.com
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateTodoDialog(
    modifier: Modifier = Modifier,
    todoItem: TodoItem,
    onDismiss: () -> Unit,
    onConfirm: (TodoItem) -> Unit,
) {

    var text by remember { mutableStateOf(todoItem.title) }

    BasicAlertDialog(
        modifier = modifier.clip(RoundedCornerShape(20)),
        onDismissRequest = onDismiss,
    ) {
        Surface {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { newValue ->
                        text = newValue.trimStart()
                    },
                )

                Spacer(modifier = modifier.padding(2.dp))

                TextButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onConfirm(todoItem.copy(title = text))
                            onDismiss()
                        }
                    }
                ) {
                    Text("Update Todo")
                }
            }
        }
    }
}