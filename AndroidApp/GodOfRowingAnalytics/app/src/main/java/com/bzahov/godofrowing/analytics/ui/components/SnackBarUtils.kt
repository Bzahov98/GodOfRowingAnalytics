package com.bzahov.godofrowing.analytics.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SnackbarDemo(stringId: Int, hideSnackbar: () -> Unit){
    Snackbar (
        backgroundColor = Color.Black,
        action = {
            Text(
                text = "HIDE",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        hideSnackbar()
                    },
                style = androidx.compose.ui.text.TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary
                )
            )
        }
    ){
        Text(text = stringResource(id = stringId))
    }
}