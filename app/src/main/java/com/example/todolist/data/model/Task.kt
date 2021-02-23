package com.example.todolist.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "task_table")

data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var taskDescription: String
) : Serializable
