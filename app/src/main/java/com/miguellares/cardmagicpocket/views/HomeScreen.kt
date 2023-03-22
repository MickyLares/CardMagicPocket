package com.miguellares.cardmagicpocket.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.miguellares.cardmagicpocket.model.Cards

@Composable
fun HomeScreen(navController: NavController, cardsList: List<Cards>) {
    LazyColumn() {
        items(cardsList.size){
                index->
                CardItem(cardsList[index], onCardClick = {navController.navigate("Details/$index")})
        }
    }


}