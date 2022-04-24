package com.bzahov.godofrowing.analytics.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun RowingLogo(modifier: Modifier = Modifier, text: String = "Rowing Analytics") {
    // TODO create add image as logo
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = modifier.padding(bottom = 16.dp),
        style = MaterialTheme.typography.h3,
        color = Color.Red.copy(alpha = 0.5f)
    )
}