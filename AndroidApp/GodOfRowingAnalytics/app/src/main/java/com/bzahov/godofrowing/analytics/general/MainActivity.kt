package com.bzahov.godofrowing.analytics.general

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bzahov.godofrowing.analytics.navigation.RowingNavigation
import com.bzahov.godofrowing.analytics.ui.theme.GodOfRowingAnalyticsTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                LoadNavigation()
            }
        }
    }

    @Composable
    private fun TestDBconnection() {
        val db = FirebaseFirestore.getInstance()
        val user: MutableMap<String, Any> = HashMap()

        user["first Name"] = "Bozho"
        user["last Name"] = "Zahov"

        db.collection("users")
            .add(user)
            .addOnSuccessListener { Log.d("TAG", "success") }
            .addOnFailureListener { Log.d("TAG", "error") }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        LoadNavigation()
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    /*
      content: @Composable ... it's called a container function
      which makes MyApp more flexible to deal with
     */
    GodOfRowingAnalyticsTheme() {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }


}

@Composable
fun LoadNavigation() {

    Surface(color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize(), content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RowingNavigation()
            }
        })

}