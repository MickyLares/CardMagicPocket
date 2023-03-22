package com.miguellares.cardmagicpocket

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.miguellares.cardmagicpocket.model.Cards
import com.miguellares.cardmagicpocket.navigation.Navigation

@Composable
fun CardApp(cardsList: List<Cards>) {
    val scrollState = rememberScrollState()
    val navController = rememberNavController()
    MainScreen(navController, scrollState, cardsList)
}

@Composable
fun MainScreen(
    navController: NavHostController,
    scrollState: ScrollState,
    myCardsList: List<Cards>
) {
    Scaffold() {
        Navigation(
            navController = navController,
            scrollState = scrollState,
            cardList = myCardsList,
            paddingValues = it
        )
    }


}
