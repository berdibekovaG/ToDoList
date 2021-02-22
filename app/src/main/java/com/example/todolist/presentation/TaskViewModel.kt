package com.example.todolist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.model.Task
import com.example.todolist.data.TaskDataBase

import com.example.todolist.data.TaskRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TaskViewModel(application: Application): AndroidViewModel(application){

    private val taskListLiveData: MutableLiveData<List<Task>> = MutableLiveData()
    private val repository: TaskRepository

    init {
        val taskDao = TaskDataBase.getDataBase(application).taskDao()
        repository = TaskRepository(taskDao)
        fetchAllTasks()
    }

    fun getTaskListLiveData(): LiveData<List<Task>> = taskListLiveData

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
            fetchAllTasks()
        }
    }

    fun updateTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(task)
            fetchAllTasks()
        }
    }

    fun onDeleteClicked(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(task)
            fetchAllTasks()
        }
    }

    private fun fetchAllTasks() {
        viewModelScope.launch(Dispatchers.Main) {
            taskListLiveData.value = withContext(Dispatchers.IO) {
                repository.getAllTasks()
            }
        }
    }
}

