package fr.antoinev.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.antoinev.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TodoAppScreen()
                }
            }
        }
    }
}

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object CreateTodo : Routes("todo_create")
}

@Composable
fun TodoAppScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) { Home() }
        composable(Routes.CreateTodo.route) {  }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoAppTheme {
        TodoAppScreen()
    }
}