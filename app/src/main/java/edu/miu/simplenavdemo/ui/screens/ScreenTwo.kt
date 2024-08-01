package edu.miu.simplenavdemo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController




@Composable
fun ScreenTwo(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go to Previous")
        }
        Text(text = "Screen Two")
        Button(onClick = {navController.navigate("screen-3") }) {
            Text(text = "Go to Screen Three")
        }
    }
}