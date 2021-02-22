package com.example.todolist.presentation

import com.example.todolist.data.model.Task

interface TaskClickListener {

    fun onDeleteClicked(task: Task)

    fun onTaskClicked(task: Task)
}