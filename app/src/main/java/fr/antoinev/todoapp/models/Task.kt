package fr.antoinev.todoapp.models

data class Task(
    val id: Int,
    val name: String,
    var done: Boolean = false
)
