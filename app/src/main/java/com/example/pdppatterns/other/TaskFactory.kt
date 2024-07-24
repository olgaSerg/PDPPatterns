package com.example.pdppatterns.other

class TaskFactory {

    fun createTask(type: TaskType, title: String, deadline: String = ""): Task {
        return when (type) {
            TaskType.SIMPLE -> SimpleTask(title)
            TaskType.DEADLINE -> DeadlineTask(title, deadline)
        }
    }
}