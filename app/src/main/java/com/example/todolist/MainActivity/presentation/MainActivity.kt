package com.example.todolist.MainActivity.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.AddTaskActivity
import com.example.todolist.R
import com.example.todolist.dataRoom.TaskDao
import com.example.todolist.dataRoom.TaskDataBase
import com.example.todolist.dataRoom.TaskViewModel
import com.example.todolist.model.Task
import com.example.todolist.ui.ItemClicked
import com.example.todolist.ui.TaskAdapter
import com.example.todolist.ui.UpdateTaskActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text
import java.lang.reflect.Array.get

class MainActivity() : AppCompatActivity(), ItemClicked{

    private lateinit var dataBase: TaskDataBase
    private lateinit var mtaskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mtaskViewModel=  ViewModelProvider(this).get(TaskViewModel::class.java)
        val adapter = TaskAdapter(::openToUpdateTask)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_tasks)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mtaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        mtaskViewModel.readAllData.observe(this, Observer { task ->
            adapter.setData(task)

            openAddTaskActivity()

        })
    }


    private fun openToUpdateTask(task: Task) {
        val editText = findViewById<TextView>(R.id.textView_task_in_card).text.toString()

        intent = Intent(this, AddTaskActivity::class.java)
        intent.putExtra("selected_task", task)
        startActivity(intent)
        Log.v("TAG", "Was called")

    }


//    private fun deleteTask(task: Task) {
//        mtaskViewModel.deleteTask(task = task)
//    }

    private fun openAddTaskActivity(){
        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener {
            intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun updateClicked(task: Task) {
        TODO("Not yet implemented")
    }

    override fun deleteClicked(task: Task) {
        mtaskViewModel.deleteTask(task)
    }
}
