package com.example.notetaker

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.room.Room
import com.example.notetaker.db.NotesDb
import com.example.notetaker.ui.theme.NoteTakerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NoteTakerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(top = 32.dp)
                ) {
                    App()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun App() {
    // We won't use this `navController` for now,
    // but it's needed to setup the `NavHost`.

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController= navController)
        }

        composable(route = "edit") {
            EditScreen(navRoute = { navController.navigate("home") })
        }

        composable(route = "edit/{id}") {
            val id = it.arguments?.getString("id")?.toInt()
            EditScreen(navRoute = { navController.navigate("home") }, id=id)
        }
    }
}
