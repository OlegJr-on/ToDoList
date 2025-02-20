package com.mytodoapp.data.repository

import com.mytodoapp.data.local.TaskDao
import com.mytodoapp.data.local.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao) {

    // 🔹 Fetch all tasks from database
    fun getAllTasks(): Flow<List<TaskEntity>> = taskDao.getAllTasks()

    // 🔹 Insert a new task
    suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    // 🔹 Delete a task
    suspend fun deleteTask(task: TaskEntity) {
        taskDao.deleteTask(task)
    }
}
