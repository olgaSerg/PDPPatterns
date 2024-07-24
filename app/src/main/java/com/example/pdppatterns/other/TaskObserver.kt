package com.example.pdppatterns.other

interface TaskObserver {

    fun update(tasks: List<Task>)
}