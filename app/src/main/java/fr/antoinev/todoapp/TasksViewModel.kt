package fr.antoinev.todoapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import fr.antoinev.todoapp.models.Task

class TasksViewModel: ViewModel() {

    var tasks = mutableStateListOf(Task(1, "Manger"), Task(2, "German"), Task(3, "Regnam"))
        private set

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun editTask(last: Task, task: Task) {
        tasks[tasks.indexOf(last)] = task
    }

    fun nextId(): Int {
        return tasks.maxOf { it.id } + 1
    }

}