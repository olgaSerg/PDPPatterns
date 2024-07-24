package com.example.pdppatterns.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pdppatterns.R
import com.example.pdppatterns.base.BaseFragment
import com.example.pdppatterns.databinding.FragmentTodolistBinding

private const val DATE_FORMAT = "%04d-%02d-%02d"

class TodoListFragment : BaseFragment<FragmentTodolistBinding>(), TaskObserver {

    private val taskFactory = TaskFactory()
    private val taskSorter: TaskSorter by lazy { TaskSorter() }
    private val taskManager: TaskManager = TaskManager.getInstance()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTodolistBinding {
        return FragmentTodolistBinding.inflate(inflater)
    }

    override fun onStart() {
        super.onStart()
        taskManager.addObserver(this)
    }

    override fun onStop() {
        taskManager.removeObserver(this)
        super.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addSimpleTaskButton.setOnClickListener {
            val title = binding.taskTitleEditText.text.toString()
            val task = taskFactory.createTask(TaskType.SIMPLE, title)
            taskManager.addTask(task)
        }

        binding.addDeadlineTaskButton.setOnClickListener {
            val title = binding.taskTitleEditText.text.toString()
            val datePicker = binding.deadlinePicker
            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1
            val year = datePicker.year
            val deadline = String.format(DATE_FORMAT, year, month, day)
            val task = taskFactory.createTask(TaskType.DEADLINE, title, deadline)
            taskManager.addTask(task)
        }

        binding.sortByTitleButton.setOnClickListener {
            taskSorter.setCommand(SortByTitleCommand())
            update(taskManager.getTasks())
        }

        binding.sortByDeadlineButton.setOnClickListener {
            taskSorter.setCommand(SortByDeadlineCommand())
            update(taskManager.getTasks())
        }
    }

    override fun update(tasks: List<Task>) {
        val sortedTasks = taskSorter.sortTasks(tasks)
        binding.tasksTextView.text = sortedTasks.joinToString("\n") { task ->
            when (task) {
                is SimpleTask -> getString(R.string.simple_task, task.title)
                is DeadlineTask -> getString(R.string.deadline_task, task.title, task.deadline)
                else -> task.title
            }
        }
    }
}