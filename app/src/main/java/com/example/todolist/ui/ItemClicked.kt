package com.example.todolist.ui

import com.example.todolist.model.Task

interface ItemClicked {
    fun updateClicked(task: Task)

    fun deleteClicked(task: Task)
}