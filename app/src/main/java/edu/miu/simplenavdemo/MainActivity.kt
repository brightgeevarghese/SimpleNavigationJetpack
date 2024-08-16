package edu.miu.simplenavdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import edu.miu.simplenavdemo.ui.components.TopBar
import edu.miu.simplenavdemo.ui.navigation.NavigationGraph
import edu.miu.simplenavdemo.ui.screens.ScreenOne
import edu.miu.simplenavdemo.ui.screens.ScreenThree
import edu.miu.simplenavdemo.ui.screens.ScreenTwo
import edu.miu.simplenavdemo.ui.theme.SimpleNavDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleNavDemoTheme {
                //Create a NavHostController and remember it across recompositions
                val navHostController: NavHostController = rememberNavController()
                NavigationGraph(navHostController)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ScreenOnePreview() {
    SimpleNavDemoTheme {
        val navController = rememberNavController()
        ScreenOne(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenTwoPreview() {
    SimpleNavDemoTheme {
        val navController = rememberNavController()
        ScreenTwo(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenThreePreview() {
    SimpleNavDemoTheme {
        val navController = rememberNavController()
        ScreenThree(navController = navController)
    }
}