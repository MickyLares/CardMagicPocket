package com.miguellares.cardmagicpocket.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguellares.cardmagicpocket.model.Cards
import com.miguellares.cardmagicpocket.network.ApiService
import kotlinx.coroutines.launch

class CardsViewModel : ViewModel() {
    var cardsListResponse: List<Cards> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getCardsList(): List<Cards> {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()

            try {
                val cardList = apiService.getCardList()
                cardsListResponse = cardList.body()?.results ?: emptyList()

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
        return cardsListResponse
    }
}