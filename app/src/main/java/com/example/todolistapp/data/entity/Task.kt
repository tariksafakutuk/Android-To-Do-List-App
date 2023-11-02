package com.example.todolistapp.data.entity

data class Task(var taskId: Int,
                var taskTitle: String,
                var taskDate: String,
                var taskTime: String,
                var taskActivated: Boolean) {
}