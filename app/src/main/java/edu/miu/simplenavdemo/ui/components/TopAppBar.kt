package edu.miu.simplenavdemo.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navHostController: NavController) {

    // State to determine if the back navigation icon should be shown
    var canNavigateBack by remember {
        // Initialize state to false (i.e., no back navigation initially)
        mutableStateOf(false)
    }
    // Listener to update the state when the navigation destination changes
    navHostController.addOnDestinationChangedListener { controller, destination, arguments ->
        // Set canNavigateBack to true if the current destination is not "screen-1"
        canNavigateBack = destination.route != "screen-1"
    }

    TopAppBar(
        title = { Text(text = "Simple Navigation") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            // Determine the icon to show based on whether navigation back is possible
            val navIcon = if (canNavigateBack) {
                Icons.AutoMirrored.Filled.ArrowBack // Show back arrow icon if navigation is possible
            } else {
                Icons.Filled.Home // Show home icon if navigation is not possible
            }
            // IconButton is used to handle clicks on the navigation icon
            IconButton(onClick = {
                // Navigate up if the back navigation is possible
                if (canNavigateBack) navHostController.navigateUp()
            }) {
                // Display the appropriate icon in the button
                Icon(imageVector = navIcon, contentDescription = "Nav Icon")
            }
        }
    )
}