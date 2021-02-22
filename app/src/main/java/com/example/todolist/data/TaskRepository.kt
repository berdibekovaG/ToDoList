package com.example.todolist.data

import com.example.todolist.data.model.Task

class TaskRepository(
    private val taskDao: TaskDao
) {

    fun getAllTasks(): List<Task> = taskDao.getTaskList()

    fun addTask(task: Task) {
        taskDao.addTask(task)
    }

    fun updateTask(task: Task) {
        taskDao.addTask(task)
    }

    fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}