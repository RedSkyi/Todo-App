package fr.antoinev.todoapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.antoinev.todoapp.models.Task
import fr.antoinev.todoapp.ui.theme.TodoAppTheme
import fr.antoinev.todoapp.ui.theme.VeryDarkGrayishBlue

@Suppress("OPT_IN_IS_NOT_ENABLED")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(tasksViewModel: TasksViewModel = viewModel()) {
    Column(modifier = Modifier.padding(10.dp)) {
        HomeTitle(Modifier.padding(vertical = 50.dp))

        LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
            items(tasksViewModel.tasks.sortedBy { it.done }, key = { it.id }) { task ->
                TaskRow(task, Modifier.animateItemPlacement()) { tasksViewModel.editTask(task, task.copy(done = it)) }
            }
        }

        AddTask(onClick = { tasksViewModel.addTask(Task(tasksViewModel.nextId(), it)) })
    }
}

@Composable
private fun HomeTitle(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(start = 30.dp)
    ) {
        Text(text = "👋", style = TextStyle(fontSize = 32.sp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = stringResource(id = R.string.hi), style = MaterialTheme.typography.h1)
            Text(text = stringResource(id = R.string.welcome_title))
        }
    }
}

@Composable
private fun AddTask(onClick: (String) -> Unit, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    Row(modifier = modifier) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.width(10.dp))
        Button(
            onClick = { onClick(text) },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
        ) {
            Text(text = "Ajouter")
        }
    }
}

@Composable
private fun TaskRow(task: Task, modifier: Modifier = Modifier, onChecked: (Boolean) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Checkbox(
            checked = task.done,
            onCheckedChange = onChecked,
            colors = CheckboxDefaults.colors(
                uncheckedColor = MaterialTheme.colors.primary,
                checkedColor = MaterialTheme.colors.primary,
                checkmarkColor = MaterialTheme.colors.background
            )
        )
        Text(
            text = task.name,
            color = if (task.done) MaterialTheme.colors.primaryVariant
            else MaterialTheme.colors.primary
        )
    }
}

@Composable
@Preview(backgroundColor = 0xFF2B2D42, showBackground = true)
fun HomePreview() {
    TodoAppTheme {
        Surface(Modifier.fillMaxSize(), color = VeryDarkGrayishBlue) {
            Home()
        }
    }
}
