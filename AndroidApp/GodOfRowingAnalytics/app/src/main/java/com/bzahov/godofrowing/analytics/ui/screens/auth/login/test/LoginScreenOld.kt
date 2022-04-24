package com.bzahov.godofrowing.analytics.ui.screens.auth.login.test

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bzahov.godofrowing.analytics.R
import com.bzahov.godofrowing.analytics.ui.components.CardLayout
import com.bzahov.godofrowing.analytics.ui.components.GoogleButton
import com.bzahov.godofrowing.analytics.ui.components.RowingLogo
import com.bzahov.godofrowing.analytics.ui.components.RowingLogoImageGallery
import com.bzahov.godofrowing.analytics.presentation.navigation.AppScreen
import com.bzahov.godofrowing.analytics.ui.activities.MyApp
import com.bzahov.godofrowing.analytics.ui.screens.auth.login.AuthState
import com.bzahov.godofrowing.analytics.ui.screens.auth.login.LoginScreenViewModel
import com.bzahov.godofrowing.analytics.ui.screens.auth.login.Status
import com.bzahov.godofrowing.analytics.utils.ValidationFieldUtils.Companion.isEmailValid
import com.bzahov.godofrowing.analytics.utils.ValidationFieldUtils.Companion.isPasswordValid

private const val TAG = "LoginScreen"

@Composable
fun LoginScreenOld(
    navController: NavController = rememberNavController(),
    viewModel: LoginScreenViewModel = hiltViewModel()
) {

    val authStateProgression = viewModel.authState// { mutableStateOf(Logging) }
//    val authStateProgression = rememberSaveable { mutableStateOf(Logging) }
    val authStatus = viewModel.authStatus//rememberSaveable { mutableStateOf(Status.IDLE) }
//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember { SnackbarHostState() }

//    var viewmodel.onStateChanged(authStateauthStateProgression.value.value

    LinearProgressIndicator()

    when (authStateProgression.value) {
        AuthState.Logging -> {
            CardLayout(
                upperContent = {
                    RowingLogoImageGallery(imageId = R.drawable.ic_google_logo)
                }) {
                when (authStatus.value) {
                    Status.IDLE -> {
                        LoginFormOld(authStatus.value?: Status.FAILED,
                            onForgotPassword = {
                                viewModel.onStateChanged(AuthState.ForgotPassword)
                                viewModel.onStatusChanged(Status.IDLE)
                            },
                            onSignUp = {
                                viewModel.onStateChanged(AuthState.SigningUp)
                                viewModel.onStatusChanged(Status.IDLE)
                            }, onLoggedIn = { email, password ->
                                viewModel.signInWithEmailAndPassword(email, password,
                                    failedLogin = {
                                        viewModel.onStateChanged(AuthState.Logging)
                                        viewModel.onStatusChanged(Status.FAILED)
                                    },
                                    successfulLogin = {
                                        viewModel.onStateChanged(AuthState.Logging)
                                        viewModel.onStatusChanged(Status.SUCCESS)
                                    })
                            }
                        )
                    }
                    Status.LOADING -> {
                        Box(Modifier.fillMaxSize()) {
                            Text(text = "LOADING")
                        }
                    }
                    Status.SUCCESS -> {
                        Log.e(TAG,"authStateProgression.value ${authStateProgression.value} Status.SUCCESS")
                        navController.navigate(AppScreen.Home.route)
                    }
                    Status.FAILED -> {
                        Box(Modifier.fillMaxSize()) {
                            Text(text = "FAILED")
                        }
                    }
                    else -> {
                        Log.e(TAG,"authStatus ${authStatus.value} is unasigned")
                    }
                }
            }
        }
        AuthState.SigningUp -> {

            CardLayout(
                upperContent = {
                    RowingLogo()
                }) {
                Box(Modifier.fillMaxSize()) {
                    Text(text = "SigningUp")
                }
            }
//            navController.navigate(AppScreen.Register.route)
        }
        AuthState.ForgotPassword -> {
            Box() {
                Text(text = "ForgotPassword")
            }
        }
        else -> {
            Log.e(TAG,"authState ${authStateProgression.value} is unasigned")
        }
    }
}


//        if (false) {
//            LoginForm(authStateProgression.value) { email, password ->
//                viewModel.signInWithEmailAndPassword(email, password,
//                    failedLogin = {
//
//                    }) {
//                    navController.navigate(AppScreen.Home.route)
//                }
//            }
//        } else {
//            LoginForm(loading = false) { email, password ->
//                viewModel.createUserWithEmailAndPassword(email, password) {
//                    navController.navigate(AppScreen.Register.route)
//                }
//            }
//        }


@Composable
private fun LoginFormOld(
    loading: Status = Status.IDLE,
    onSignUp: (String) -> Unit = { email -> },
    onForgotPassword: (String) -> Unit = { email -> },
    onLoggedIn: (String, String) -> Unit = { email, pwd -> }
) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val isFormValid by derivedStateOf {
        isEmailValid(email) && isPasswordValid(password)
    }
    if(loading == Status.LOADING) {
        CustomLinearProgressBar()
    }else{Box{}}
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Text(
            text = stringResource(R.string.login_welcome_message),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                isError = !isEmailValid(email),
                onValueChange = { email = it },
                label = { Text(text = stringResource(R.string.auth_username)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                trailingIcon = {
                    if (email.isNotBlank())
                        IconButton(onClick = { email = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = ""
                            )
                        }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.auth_password)) },
                singleLine = true,
                isError = !isPasswordValid(password),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = stringResource(R.string.content_descr_password_toggle)
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onLoggedIn(email.trim(), password.trim()) },
                enabled = isFormValid,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = stringResource(R.string.auth_login))
            }
            Spacer(modifier = Modifier.weight(1f))

            GoogleButton() {
                // TODO Log view Google account
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = {
                    onSignUp(email)
                    email = ""
                    password = ""
                }) { // Sign Up Button
                    Text(text = stringResource(R.string.auth_signup))
                }
                TextButton(onClick = { onForgotPassword(email) }) { // Forgot Password
                    Text(
                        text = stringResource(R.string.auth_password_forgot),
                        color = Color.Gray,
                        style = TextStyle(textDecoration = TextDecoration.Underline)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Surface() {
            
        }
        LoginFormOld()
    }
}

@Composable
private fun CustomLinearProgressBar(){
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp),
            backgroundColor = Color.LightGray,
            color = Color.Red)
    }
}