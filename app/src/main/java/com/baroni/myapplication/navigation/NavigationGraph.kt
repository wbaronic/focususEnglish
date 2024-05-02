package com.baroni.myapplication.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.baroni.myapplication.screens.ExploreScreen
import com.baroni.myapplication.screens.RestaurantsScreen
import com.baroni.myapplication.screens.TalkScreen

sealed class Screen(val route: String) {
  //  object Home : Screen("home")
    object Explore : Screen("explore")
    object Restaurant : Screen("restaurant")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationGraph(contentPadding: PaddingValues, onTitleChanged: (String) -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Explore.route) {
//        composable(Screen.Home.route) {
//            HomeScreen(
//                contentPadding,
//                onTitleChanged = onTitleChanged,
//                onNavigateToExplore = {
//                    navController.navigate(Screen.Explore.route)
//                }
//            )
//        }
        composable(Screen.Explore.route) {
            ExploreScreen(
                contentPadding,
                onTitleChanged = onTitleChanged,
                onNavigateToRestaurant = {
                        name -> navController.navigate(
                            "${Screen.Restaurant.route}/$name")
                }
            )
        }
        composable(
            "${Screen.Restaurant.route}/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) {
                backStackEntry->
                    TalkScreen(
                        viewModel= viewModel(),
                        contentPadding,
                        restaurantName = backStackEntry.arguments?.getString("name"),
                        onTitleChanged = onTitleChanged,
                        onNavigateToExplore = { navController.navigate(Screen.Explore.route) }
                    )
        }

//        composable(
//            "${Screen.Restaurant.route}/{name}",
//            arguments = listOf(navArgument("name") { type = NavType.StringType })
//        ) {
//                backStackEntry->
//            RestaurantsScreen(
//                contentPadding,
//                restaurantName = backStackEntry.arguments?.getString("name"),
//                onTitleChanged = onTitleChanged,
//                onNavigateToExplore = { navController.navigate(Screen.Explore.route) }
//            )
//        }
    }
}
