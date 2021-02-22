package com.example.todolist.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.model.Task

class RecyclerTaskViewHolder(
    itemView: View,
    private val taskClickListener: TaskClickListener
) : RecyclerView.ViewHolder(itemView) {

    private val deleteButton: ImageView = itemView.findViewById(R.id.ic_delete)
    private val taskTextView: TextView = itemView.findViewById(R.id.textView_task_in_card)
    private lateinit var task: Task

    init {
        deleteButton.setOnClickListener {
            taskClickListener.onDeleteClicked(task)
        }
        taskTextView.setOnClickListener {
            taskClickListener.onTaskClicked(task)
        }
    }

    fun onBind(task: Task) {
        this.task = task
        taskTextView.text = task.taskDescription
    }
}
