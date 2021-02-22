package com.example.todolist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.model.Task

class TaskAdapter(
    private val taskClickListener: TaskClickListener
) : RecyclerView.Adapter<RecyclerTaskViewHolder>() {

    private var taskList: MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_task,
            parent,
            false
        )

        return RecyclerTaskViewHolder(view, taskClickListener)
    }

    override fun getItemCount(): Int = taskList.size

    fun setData(task: List<Task>) {
        taskList.clear()
        taskList.addAll(task)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerTaskViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.onBind(currentItem)
    }
}
