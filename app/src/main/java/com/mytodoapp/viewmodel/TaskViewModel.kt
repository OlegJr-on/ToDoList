package com.mytodoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytodoapp.data.local.TaskEntity
import com.mytodoapp.data.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    fun getAllTasks(): Flow<List<TaskEntity>> = repository.getAllTasks()

    fun removeTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun addTask(taskName: String) {
        viewModelScope.launch {
            repository.insertTask(TaskEntity(taskName = taskName))
        }
    }
}
