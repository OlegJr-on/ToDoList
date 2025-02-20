package com.mytodoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateListOf<String>()
    val tasks: List<String> get() = _tasks

    fun addTask(task: String) {
        _tasks.add(task)
    }

    fun removeTask(task: String) {
        _tasks.remove(task)
    }
}
