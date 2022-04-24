package com.bzahov.godofrowing.analytics.ui.screens.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bzahov.godofrowing.analytics.R
import com.bzahov.godofrowing.analytics.ui.theme.*

@Preview
@Composable
fun RegisterScreen(
    navController: NavController = rememberNavController(),
    viewModel: RegisterScreenViewModel = hiltViewModel()
) {
    //Text(text = getCurrentScreenByNavController(navController).title)
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checkBoxOne by remember { mutableStateOf(true) }
    var checkBoxTwo by remember { mutableStateOf(true) }
    RegisterView(username, email, password, checkBoxOne, checkBoxTwo)
}

@Composable
private fun RegisterView(
    username: String,
    email: String,
    password: String,
    checkBoxOne: Boolean,
    checkBoxTwo: Boolean
) {
    var username1 = username
    var email1 = email
    var password1 = password
    var checkBoxOne1 = checkBoxOne
    var checkBoxTwo1 = checkBoxTwo
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_register_img),
            contentDescription = "",
            modifier = Modifier.size(160.dp)
        )

        Text(
            text = "CREATE YOUR ACCOUNT",
            textAlign = TextAlign.Center,
            fontFamily = Poppins,
            color = SecondaryColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,

            )

        TextField(
            value = username1, onValueChange = { username1 = it },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_user), contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(6.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .height(24.dp)
                            .background(BackgroundColor)
                    )
                }
            },
            placeholder = {
                Text(text = "Username", color = PlaceholderColor)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        TextField(
            value = email1, onValueChange = { email1 = it },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email_outline),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(6.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .height(24.dp)
                            .background(BackgroundColor)
                    )
                }
            },
            placeholder = {
                Text(text = "Email Address", color = PlaceholderColor)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        TextField(
            value = password1, onValueChange = { password1 = it },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = PrimaryColor,
                backgroundColor = Color.White,
                cursorColor = PrimaryColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = InputBoxShape.medium,
            singleLine = true,
            leadingIcon = {
                Row(
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock), contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(6.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(1.dp)
                            .height(24.dp)
                            .background(BackgroundColor)
                    )
                }
            },
            placeholder = {
                Text(text = "Password", color = PlaceholderColor)
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )
        )

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkBoxOne1, onCheckedChange = { checkBoxOne1 = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = PrimaryColor,
                    uncheckedColor = SecondaryColor,
                    checkmarkColor = SecondaryColor
                ),
                modifier = Modifier.clip(shape = Shapes.medium)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Log In with Email",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 12.sp
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkBoxTwo1, onCheckedChange = { checkBoxTwo1 = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = PrimaryColor,
                    uncheckedColor = SecondaryColor,
                    checkmarkColor = SecondaryColor
                ),
                modifier = Modifier.clip(shape = Shapes.medium)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Email me about special pricing",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 12.sp
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = PrimaryColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            contentPadding = PaddingValues(vertical = 14.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 2.dp
            ),
            shape = Shapes.medium
        ) {
            Text(
                text = "Sign Up with Email",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        SocialMediaSignInButtons()

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(
                text = "Already have an account ? Sign In",
                fontFamily = Poppins,
                color = SecondaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Composable
fun SocialMediaSignInButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            modifier = Modifier.clip(shape = Shapes.large),
            contentPadding = PaddingValues(horizontal = 26.dp, vertical = 10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Google",
                    fontFamily = Poppins,
                    color = SecondaryColor
                )
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
            ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            modifier = Modifier.clip(shape = Shapes.large),
            contentPadding = PaddingValues(horizontal = 26.dp, vertical = 10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "",
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Facebook",
                    fontFamily = Poppins,
                    color = SecondaryColor
                )
            }
        }
    }
}


// Auth