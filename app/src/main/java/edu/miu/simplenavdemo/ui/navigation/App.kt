package edu.miu.simplenavdemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.miu.simplenavdemo.ui.screens.ScreenOne
import edu.miu.simplenavdemo.ui.screens.ScreenThree
import edu.miu.simplenavdemo.ui.screens.ScreenTwo

@Composable
fun App(navHostController: NavHostController, modifier: Modifier = Modifier) {

    // Create a NavHost which manages the navigation between composable screens
    NavHost(navController = navHostController, startDestination = "screen-1") {
        // Define the composable functions for each screen in the navigation graph

        // Screen 1 composable
        composable(route = "screen-1") {
            ScreenOne(navController = navHostController, modifier = modifier)
        }
        // Screen 2 composable
        composable(route = "screen-2") {
            ScreenTwo(navController = navHostController, modifier = modifier)
        }
        // Screen 3 composable
        composable(route = "screen-3") {
            ScreenThree(navController = navHostController, modifier = modifier)
        }
    }
}