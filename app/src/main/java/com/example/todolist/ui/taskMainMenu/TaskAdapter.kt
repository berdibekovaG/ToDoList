package com.example.todolist.ui.taskMainMenu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Task
import com.example.todolist.dataRoom.TaskViewModel

const val TAG = "was invoked"

class TaskAdapter(
        onClick: (task: Task) -> Unit,
) : RecyclerView.Adapter<TaskAdapter.RecyclerTaskViewHolder>() {


    private var taskList: MutableList<Task> = mutableListOf()
    private var onClick: (task: Task) -> Unit = onClick

    private lateinit var deleteButton: ImageView

    class RecyclerTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerTaskViewHolder {
        return RecyclerTaskViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.card_task, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(task: List<Task>) {
        taskList.clear()
        taskList.addAll(task)
        notifyDataSetChanged()
    }

    fun deleteData(task: Task) {
        taskList.clear()
        taskList.remove(task)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerTaskViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.itemView.findViewById<TextView>(R.id.textView_task_in_card).text =
                currentItem.taskDescription


        holder.itemView.setOnClickListener {
            onClick.invoke(taskList[position])
        }

        deleteButton = holder.itemView.findViewById(R.id.ic_delete)
        deleteButton.setOnClickListener {
            deleteData(task = taskList[position])
        }
    }
}
