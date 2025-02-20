package com.mytodoapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mytodoapp.data.local.TaskEntity
import com.mytodoapp.R

@Composable
fun TaskItem(task: TaskEntity, onDelete: (TaskEntity) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_delete),
            contentDescription = "Delete Task",
            modifier = Modifier
                .size(24.dp)
                .clickable { onDelete(task) },
            tint = Color.Red
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = task.taskName, modifier = Modifier.padding(8.dp))
    }
}
