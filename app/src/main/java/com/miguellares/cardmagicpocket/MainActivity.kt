package com.miguellares.cardmagicpocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.miguellares.cardmagicpocket.ui.theme.CardMagicPocketTheme
import com.miguellares.cardmagicpocket.viewmodels.CardsViewModel
import com.miguellares.cardmagicpocket.views.CardsItemEmpty

class MainActivity : ComponentActivity() {
    private val cardViewModel by viewModels<CardsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardMagicPocketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    val cardslist = cardViewModel.getCardsList()
                    if (cardslist.isNotEmpty()) {
                        CardApp(cardsList = cardViewModel.cardsListResponse)
                    } else {
                        CardsItemEmpty()
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun previewLayoutMain(){
    CardApp(cardsList = listOf())
}

