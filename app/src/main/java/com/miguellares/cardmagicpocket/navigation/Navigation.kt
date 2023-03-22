package com.miguellares.cardmagicpocket.navigation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miguellares.cardmagicpocket.model.Cards
import com.miguellares.cardmagicpocket.views.CardItemDetail
import com.miguellares.cardmagicpocket.views.HomeScreen

sealed class AppScreen(val route: String) {
    object HomeScreen : AppScreen("Inicio")
    object DetailScreen : AppScreen("Detail")
}

@Composable
fun Navigation(
    navController: NavHostController,
    scrollState: ScrollState,
    cardList: List<Cards>,
    paddingValues: PaddingValues
) {
    cardList.let {
        NavHost(
            navController = navController,
            startDestination = AppScreen.HomeScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            bottomNavigation(navController, cardList)
            composable(
                "Detail/{index}", listOf(navArgument("index") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val index = navBackStackEntry.arguments?.getInt("index")
                index?.let {
                    val cards = cardList[index]
                    CardItemDetail(
                        navController = navController,
                        cards = cards,
                        scrollState = scrollState
                    )
                }

            }
        }
    }
}

fun NavGraphBuilder.bottomNavigation(navController: NavController, cardList: List<Cards>) {
    composable(AppScreen.HomeScreen.route) {
        HomeScreen(navController = navController, cardsList = cardList)
    }
    composable(AppScreen.DetailScreen.route) {

    }
}