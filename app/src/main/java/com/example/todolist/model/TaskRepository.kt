package com.example.todolist.model

import androidx.lifecycle.LiveData
import com.example.todolist.data.Task
import com.example.todolist.dataRoom.TaskDao

class TaskRepository(
        private val taskDao: TaskDao
) {
    val readAllData: LiveData<List<Task>> = taskDao.getTaskList()

    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }

    suspend fun updateTask(task: Task){
        taskDao.addTask(task)
    }
    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

}