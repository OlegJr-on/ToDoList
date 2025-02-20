package com.mytodoapp.ui.addtask

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytodoapp.viewmodel.TaskViewModel

@Composable
fun AddTaskScreen(
    navController: NavController,
    taskViewModel: TaskViewModel
) {
    var taskName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Add New Task", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = taskName,
            onValueChange = { taskName = it },
            label = { Text("Enter Task Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (taskName.isNotBlank()) {
                        taskViewModel.addTask(taskName)
                        navController.navigate("home")
                    }
                },
                enabled = taskName.isNotBlank()
            ) {
                Text(text = "Save Task")
            }

            Button(
                onClick = { navController.navigate("home") },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text(text = "🏠 Home")
            }
        }
    }
}
