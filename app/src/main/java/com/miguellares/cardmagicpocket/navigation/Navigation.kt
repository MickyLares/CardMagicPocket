package com.miguellares.cardmagicpocket.navigation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.miguellares.cardmagicpocket.model.Cards
import com.miguellares.cardmagicpocket.views.HomeScreen

sealed class AppScreen(val route: String) {
    object HomeScreen : AppScreen("Inicio")
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
        }
    }
}

fun NavGraphBuilder.bottomNavigation(navController: NavController, cardList: List<Cards>) {
    composable(AppScreen.HomeScreen.route){
        HomeScreen(navController = navController, cardsList = cardList )
    }
}