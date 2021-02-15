package com.example.todolist.dataRoom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolist.model.Task
import com.example.todolist.model.TaskRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.RowId

class TaskViewModel(application: Application): AndroidViewModel(application){

    val readAllData: LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val taskDao = TaskDataBase.getDataBase(application).taskDao()
        repository = TaskRepository(taskDao)
        readAllData = repository.readAllData
    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(task)
        }
    }
}

