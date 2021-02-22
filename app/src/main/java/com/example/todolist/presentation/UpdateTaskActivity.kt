package com.example.todolist.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R


class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var mtaskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        mtaskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        val updateTaskText = findViewById<EditText>(R.id.update_text)
        val buttonUpdate: Button = findViewById(R.id.btn_update_task)

        updateTaskText.setText(intent.getStringExtra(SELECTED_TASK))

        buttonUpdate.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }


}