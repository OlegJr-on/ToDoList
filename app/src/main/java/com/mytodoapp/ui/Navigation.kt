package com.mytodoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytodoapp.ui.addtask.AddTaskScreen
import com.mytodoapp.ui.home.HomeScreen
import com.mytodoapp.ui.tasklist.TaskListScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") { HomeScreen(navController) }
        composable("add_task") { AddTaskScreen(navController) }
        composable("task_list") { TaskListScreen(navController) }
    }
}