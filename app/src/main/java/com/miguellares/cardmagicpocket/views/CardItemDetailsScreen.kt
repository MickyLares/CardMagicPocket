package com.miguellares.cardmagicpocket.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.miguellares.cardmagicpocket.model.Cards
import com.miguellares.cardmagicpocket.R
import com.miguellares.cardmagicpocket.navigation.AppScreen
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CardItemDetail(navController: NavController, cards: Cards, scrollState: ScrollState) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .height(290.dp)
                    .border(
                        BorderStroke(
                            1.dp, colorResource(
                                id = R.color.black
                            )
                        )
                    )
            ) {
                CoilImage(
                    imageModel = cards.imagen, contentScale = ContentScale.Crop,
                    error = painterResource(id = R.drawable.baseline_image_not_supported_24),
                    placeHolder = painterResource(id = R.drawable.baseline_image_not_supported_24)
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = cards.nombre,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                    color = colorResource(id = R.color.black)
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = cards.genero,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.black)
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = cards.creado,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.black)
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = cards.estatus,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.black)
                )
            }
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = cards.especies,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = colorResource(id = R.color.black)
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 4.dp, top= 90.dp)
                    .fillMaxWidth()
            ) {
                IconButton(onClick = { navController.navigate(AppScreen.HomeScreen.route) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Back"
                    )
                }
                Text(text = "Atras", modifier = Modifier.padding(start = 10.dp, top = 10.dp))
            }
        }
    }
}