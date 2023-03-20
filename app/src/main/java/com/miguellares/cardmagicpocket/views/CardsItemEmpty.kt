package com.miguellares.cardmagicpocket.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.miguellares.cardmagicpocket.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CardsItemEmpty() {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clickable {  },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = R.drawable.persona_femina_cortada ,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.baseline_image_not_supported_24)
                        transformations(CircleCropTransformation())
                    }),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.2f)
            )
            Column(
                verticalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxHeight()
                    .padding(2.dp)
                    .weight(0.8f)
            ) {
                Text("Se ha producido un error, vuelve a realizar la carga, presionandome")
            }
        }

    }
}
