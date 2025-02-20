package com.mytodoapp.ui.tasklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mytodoapp.ui.components.TaskItem
import com.mytodoapp.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    navController: NavController,
    taskViewModel: TaskViewModel
) {
    val tasks by remember { derivedStateOf { taskViewModel.tasks } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Task List", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (tasks.isEmpty()) {
            Text(text = "No tasks available!", fontSize = 18.sp)
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(tasks) { task ->
                    TaskItem(task)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("home") }, // ✅ Home button
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "🏠 Home")
        }
    }
}
