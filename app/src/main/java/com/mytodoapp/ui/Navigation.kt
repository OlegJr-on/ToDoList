package com.mytodoapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mytodoapp.ui.addtask.AddTaskScreen
import com.mytodoapp.ui.home.HomeScreen
import com.mytodoapp.ui.tasklist.TaskListScreen
import com.mytodoapp.viewmodel.TaskViewModel

@Composable
fun Navigation(navController: NavHostController, taskViewModel: TaskViewModel) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("add_task") { AddTaskScreen(navController, taskViewModel) }
        composable("task_list") { TaskListScreen(navController, taskViewModel) }
    }
}
