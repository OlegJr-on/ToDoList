package com.mytodoapp.ui.tasklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytodoapp.ui.components.TaskItem
import com.mytodoapp.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(navController: NavController, taskViewModel: TaskViewModel) {
    val tasks by taskViewModel.getAllTasks().collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Task List", style = MaterialTheme.typography.headlineMedium)

        // 🔹 Back to Home Button
        Button(
            onClick = { navController.navigate("home") },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text("Back to Home")
        }

        // 🔹 Task List
        LazyColumn {
            items(tasks) { task ->
                TaskItem(task = task, onDelete = {
                    taskViewModel.removeTask(task)
                })
            }
        }
    }
}
