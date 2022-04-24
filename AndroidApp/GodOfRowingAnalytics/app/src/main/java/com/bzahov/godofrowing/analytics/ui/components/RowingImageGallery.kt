package com.bzahov.godofrowing.analytics.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bzahov.godofrowing.analytics.R

@Preview
@Composable
fun RowingLogoImageGallery(modifier: Modifier = Modifier, imageId: Int = R.drawable.ic_google_logo) {

    Image(
        painter = painterResource(id = imageId),
        contentDescription = "App Logo",
        modifier = Modifier
            .size(200.dp),
        colorFilter = ColorFilter.tint(Color.White)
    )
}