package com.example.todolistapp.data.datasource

import android.util.Log
import com.example.todolistapp.data.entity.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskDataSource {
    suspend fun loadTasks(): List<Task> =
        withContext(Dispatchers.IO) {
            val taskList = ArrayList<Task>()
            val t1 = Task(1, "Walk with dog", "02/11/2023", "10:00", true)
            val t2 = Task(2, "Training in the Gym", "04/11/2023", "11:30", false)
            val t3 = Task(3, "Buy apple and milk", "04/11/2023", "14:00", false)
            taskList.add(t1)
            taskList.add(t2)
            taskList.add(t3)
            return@withContext taskList
        }

    suspend fun search(queryWord: String): List<Task> =
        withContext(Dispatchers.IO) {
            val taskList = ArrayList<Task>()
            val t1 = Task(1, "Walk with dog", "02/11/2023", "10:00", true)
            taskList.add(t1)
            return@withContext taskList
        }

    suspend fun createTask(taskTitle: String, taskDate: String, taskTime: String) {
        Log.e("Message", "$taskTitle - $taskDate - $taskTime")
    }

    suspend fun updateTask(taskId: Int, taskTitle: String, taskDate: String, taskTime: String) {
        Log.e("Message", "$taskId - $taskTitle - $taskDate - $taskTime")
    }

    suspend fun setChecked(taskId: Int) {
        Log.e("Message", taskId.toString())
    }
}