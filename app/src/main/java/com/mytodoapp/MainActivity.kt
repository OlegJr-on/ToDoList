package com.mytodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.mytodoapp.data.local.TaskDatabase
import com.mytodoapp.data.repository.TaskRepository
import com.mytodoapp.ui.Navigation
import com.mytodoapp.ui.theme.MyToDoAppTheme
import com.mytodoapp.viewmodel.TaskViewModel
import com.mytodoapp.viewmodel.TaskViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 Initialize Database & Repository
        val database = TaskDatabase.getDatabase(applicationContext)
        val repository = TaskRepository(database.taskDao())

        // 🔹 Initialize ViewModel with Factory
        val taskViewModel = ViewModelProvider(
            this,
            TaskViewModelFactory(repository)
        )[TaskViewModel::class.java]

        setContent {
            MyToDoAppTheme {
                val navController = rememberNavController()
                Navigation(navController, taskViewModel)
            }
        }
    }
}
