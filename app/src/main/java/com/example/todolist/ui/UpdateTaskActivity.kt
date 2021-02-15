package com.example.todolist.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.MainActivity.presentation.MainActivity
import com.example.todolist.R
import com.example.todolist.dataRoom.TaskDataBase
import com.example.todolist.dataRoom.TaskViewModel
import com.example.todolist.model.Task

class UpdateTaskActivity : AppCompatActivity() {
private lateinit   var mtaskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        mtaskViewModel= ViewModelProvider(this).get(TaskViewModel::class.java)

        val updateTaskText = findViewById<EditText>(R.id.update_text)
        val buttonUpdate: Button = findViewById(R.id.btn_update_task)
        //  val textForUpgate =  intent.getStringExtra("selected_task")
        updateTaskText.setText(intent.getStringExtra("selected_task"))

        buttonUpdate.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }


}