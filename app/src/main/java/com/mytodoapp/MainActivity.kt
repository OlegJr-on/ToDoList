package com.mytodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mytodoapp.ui.Navigation
import com.mytodoapp.ui.theme.MyToDoAppTheme
import com.mytodoapp.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyToDoAppTheme {
                val taskViewModel: TaskViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Navigation(
                        modifier = Modifier.padding(innerPadding),
                        taskViewModel = taskViewModel
                    )
                }
            }
        }
    }
}
