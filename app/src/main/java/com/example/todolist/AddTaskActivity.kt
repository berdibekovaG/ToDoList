package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.dataRoom.TaskViewModel
import com.example.todolist.model.Task
import com.example.todolist.MainActivity.presentation.MainActivity
import kotlin.random.Random


class AddTaskActivity : AppCompatActivity() {

    private lateinit var mtaskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        mtaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        val textField = findViewById<EditText>(R.id.set_text)
        textField.setText((intent.getSerializableExtra("selected_task") as? Task)?.taskDescription ?: "")

        val button: Button = findViewById(R.id.btn_save_task)
        button.setOnClickListener {
            insertDataToDataBase()
        }

    }

    private fun insertDataToDataBase() {
        val addedTask = findViewById<EditText>(R.id.set_text).text.toString()

        if (inputCheck(addedTask)) {
            Log.v("task", intent.getSerializableExtra("selected_task").toString())
            val task = intent.getSerializableExtra("selected_task") as? Task ?: Task(0, addedTask)
            task.taskDescription = addedTask
            Log.v("task", task.toString())
            mtaskViewModel.addTask(task as Task)

            Toast.makeText(this, "Добавлено!", Toast.LENGTH_SHORT).show()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Добавьте текст!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(addedTask: String): Boolean {
        return !(TextUtils.isEmpty(addedTask))
    }
}