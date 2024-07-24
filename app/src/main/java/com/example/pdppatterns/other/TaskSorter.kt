package com.example.pdppatterns.other

class TaskSorter {

    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun sortTasks(tasks: List<Task>): List<Task> {
        return command?.execute(tasks) ?: tasks
    }
}