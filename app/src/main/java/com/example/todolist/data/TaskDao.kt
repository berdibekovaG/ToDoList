package com.example.todolist.dataRoom

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun addTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getTaskList(): LiveData<List<Task>>

    @Query ("SELECT * FROM task_table WHERE id = :taskId")
    suspend fun getTaskById(taskId: Int) : Task

    @Delete
    suspend fun deleteTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(task: Task) : Long
}