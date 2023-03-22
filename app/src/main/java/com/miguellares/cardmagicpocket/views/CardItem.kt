package com.miguellares.cardmagicpocket.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.miguellares.cardmagicpocket.model.Cards
import com.miguellares.cardmagicpocket.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CardItem(cards: Cards, onCardClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = cards.image,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.baseline_image_not_supported_24)
                        transformations(CircleCropTransformation())
                    }),
                contentDescription = cards.name
            )
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxHeight()
                    .padding(2.dp)
                    .weight(0.8f)
            ) {
                Text(text = cards.name)
            }
        }

    }
}