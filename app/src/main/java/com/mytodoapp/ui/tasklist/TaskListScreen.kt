package com.mytodoapp.ui.tasklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TaskListScreen(navController: NavController) {
    val tasks = listOf("Buy Groceries", "Complete Project", "Call Mom") // Placeholder list

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn {
            items(tasks.size) { index ->
                Text(text = tasks[index], style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
