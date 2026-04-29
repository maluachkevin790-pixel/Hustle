package com.example.hustlemate.ui.theme.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.components.AppTextField
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.Customers.HomeScreen
import com.example.hustlemate.ui.theme.HustleMateTheme

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HustleMateTheme {
        HomeScreen(navController)
    }
}

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
            label = "Email",
            onChange = { email = it }
        )

        // 🔒 Password
        AppTextField(
            value = password,
            label = "Password",
            onChange = { password = it }
        )

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
