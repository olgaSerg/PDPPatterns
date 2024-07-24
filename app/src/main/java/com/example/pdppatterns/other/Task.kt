package com.example.pdppatterns.other

abstract class Task(val title: String)

class SimpleTask(title: String) : Task(title)

class DeadlineTask(title: String, val deadline: String) : Task(title)