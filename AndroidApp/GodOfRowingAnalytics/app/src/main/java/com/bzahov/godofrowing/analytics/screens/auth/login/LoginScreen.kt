package com.bzahov.godofrowing.analytics.screens.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.bzahov.godofrowing.analytics.components.CardLayout
import com.bzahov.godofrowing.analytics.components.GoogleButton
import com.bzahov.godofrowing.analytics.components.RowingLogoImageGallery
import com.bzahov.godofrowing.analytics.general.MyApp
import com.bzahov.godofrowing.analytics.navigation.AppScreen
import com.bzahov.godofrowing.analytics.utils.ValidationFieldUtils.Companion.isEmailValid
import com.bzahov.godofrowing.analytics.utils.ValidationFieldUtils.Companion.isPasswordValid
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    viewModel: LoginScreenViewModel = hiltViewModel()
) {

    val showLoginForm = rememberSaveable { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


    CardLayout(
        upperContent = {
            RowingLogoImageGallery(imageId = R.drawable.ic_google_logo)
        }) {

        if (showLoginForm.value) {
            LoginForm(loading = false, isCreateAccount = false) { email, password ->
                viewModel.signInWithEmailAndPassword(email, password,
                    failed = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Wrong Email or password!!!")
                    }
                }) {
                    navController.navigate(AppScreen.Home.route)
                }
            }
        } else {
            LoginForm(loading = false, isCreateAccount = true) { email, password ->
                viewModel.createUserWithEmailAndPassword(email, password) {
                    navController.navigate(AppScreen.Register.route)
                }
            }
        }
    }
}

@Composable
private fun LoginForm(
    loading: Boolean = false,
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = { email, pwd -> }
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
                onClick = { onDone(email.trim(), password.trim()) },
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
                TextButton(onClick = {}) { // Sign Up Button
                    Text(text = stringResource(R.string.auth_signup))
                }
                TextButton(onClick = { }) { // Forgot Password
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
//        LogInView()
    }
}