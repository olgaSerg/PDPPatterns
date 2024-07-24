package com.example.pdppatterns.other

class TaskManager {

    private val tasks: MutableList<Task> = mutableListOf()
    private val observers: MutableList<TaskObserver> = mutableListOf()

    companion object {

        @Volatile
        private var INSTANCE: TaskManager? = null

        fun getInstance(): TaskManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: TaskManager().also { INSTANCE = it }
            }
        }
    }

    fun addTask(task: Task) {
        tasks.add(task)
        notifyObservers()
    }

    fun getTasks(): List<Task> {
        return tasks.toList()
    }

    fun addObserver(observer: TaskObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: TaskObserver) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        observers.forEach { it.update(tasks) }
    }
}