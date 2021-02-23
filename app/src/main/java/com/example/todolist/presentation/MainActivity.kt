package com.example.todolist.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.model.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton

internal const val SELECTED_TASK = "selected_task"

class MainActivity : AppCompatActivity(), TaskClickListener {

    private lateinit var mtaskViewModel: TaskViewModel
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        initRecyclerView()
        observeViewModel()
    }

    override fun onDeleteClicked(task: Task) {
        mtaskViewModel.onDeleteClicked(task)
    }

    override fun onTaskClicked(task: Task) {
        val intent = Intent(this, UpdateTaskActivity::class.java)
        intent.putExtra(SELECTED_TASK, task)
        startActivity(intent)
    }

    private fun bindViews() {
        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener {
            intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        taskAdapter = TaskAdapter(this)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_tasks)
        recyclerView.adapter = taskAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModel() {
        mtaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        mtaskViewModel.getTaskListLiveData().observe(this, { task ->
            taskAdapter.setData(task)
        })
    }
}