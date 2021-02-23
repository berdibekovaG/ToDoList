package com.example.todolist.data

import androidx.room.*
import com.example.todolist.data.model.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getTaskList(): List<Task>

    @Query("SELECT * FROM task_table WHERE id = :taskId")
    fun getTaskById(taskId: Int): Task

    @Delete
    fun deleteTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(task: Task): Long
}