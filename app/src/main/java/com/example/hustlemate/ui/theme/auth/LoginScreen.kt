package com.example.hustlemate.ui.theme.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.components.AppTextField
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.*

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(24.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp))
                .background(White, RoundedCornerShape(20.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Welcome Back 👋",
                style = MaterialTheme.typography.headlineMedium,
                color = SkyBlueDark
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Login to continue",
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 📧 Email
            AppTextField(
                value = email,
                label = "Email",
                onChange = { email = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🔒 Password
            AppTextField(
                value = password,
                label = "Password",
                onChange = { password = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🔐 Login Button
            AppButton(
                text = "Login"
            ) {
                navController.navigate(Routes.HOME)
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = {
                    navController.navigate(Routes.REGISTER)
                }
            ) {
                Text(
                    "Don't have an account? Register",
                    color = SkyBlueDark
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        LoginScreen(navController)
    }
}