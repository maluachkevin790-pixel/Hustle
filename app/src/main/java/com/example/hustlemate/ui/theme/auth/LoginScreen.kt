package com.hustlemate.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hustlemate.app.components.AppButton
import com.hustlemate.app.components.AppTextField
import com.hustlemate.app.ui.theme.Background

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Welcome Back 👋",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 📧 Email
        AppTextField(
            value = email,
            label = "Email"
        ) { email = it }

        // 🔒 Password
        AppTextField(
            value = password,
            label = "Password"
        ) { password = it }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔐 Login Button
        AppButton(text = "Login") {
            navController.navigate("home")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // ➕ Go to Register
        TextButton(onClick = {
            navController.navigate("register")
        }) {
            Text("Don't have an account? Register")
        }
    }
}

