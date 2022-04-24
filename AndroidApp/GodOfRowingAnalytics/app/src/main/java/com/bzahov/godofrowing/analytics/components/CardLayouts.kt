package com.bzahov.godofrowing.analytics.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CardLayoutWithImage(imageId: Int, content: @Composable() () -> Unit) {
    Scaffold(backgroundColor = MaterialTheme.colors.primary) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "App Logo",
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Card(
                Modifier
                    .weight(2f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp),
                content = content
            )
        }
    }
}

@Preview
@Composable
fun CardLayout(upperContent: @Composable (modifier : Modifier) -> Unit = @Composable{}, content: @Composable() () -> Unit  = @Composable{}) {
    Scaffold(backgroundColor = MaterialTheme.colors.background) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            upperContent (modifier = Modifier.weight(1f))

            Card(
                Modifier
                    .weight(3f)
                    .padding(8.dp),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                content = content
            )
        }
    }
}