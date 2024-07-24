package com.example.pdppatterns.other

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

private const val DATE_FORMAT = "yyyy-MM-dd"

interface Command {
    fun execute(tasks: List<Task>): List<Task>
}

class SortByTitleCommand : Command {
    override fun execute(tasks: List<Task>): List<Task> {
        return tasks.sortedBy { it.title }
    }
}

class SortByDeadlineCommand : Command {
    override fun execute(tasks: List<Task>): List<Task> {
        return tasks.sortedBy {
            val deadline = (it as? DeadlineTask)?.deadline
            deadline?.let { parseDate(it) } ?: Long.MAX_VALUE
        }
    }

    private fun parseDate(dateStr: String): Long {
        val format = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return try {
            format.parse(dateStr)?.time ?: Long.MAX_VALUE
        } catch (e: ParseException) {
            Long.MAX_VALUE
        }
    }
}