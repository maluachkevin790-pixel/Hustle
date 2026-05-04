package com.example.hustlemate.ui.theme.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import com.example.hustlemate.components.AppButton
import com.example.hustlemate.components.AppTextField
import com.example.hustlemate.ui.theme.HustleMateTheme

@Composable
fun RegisterScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSeller by remember { mutableStateOf(false) }

    // 🌤️ Sky blue gradient
    val skyBlueGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF87CEEB), // sky blue
            Color(0xFFE0F7FF)  // light sky
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(skyBlueGradient)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 🌟 Card container
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Create Account 🚀",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color(0xFF0288D1) // deep sky blue
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    AppTextField(
                        value = name,
                        label = "Full Name"
                    ) { name = it }

                    AppTextField(
                        value = email,
                        label = "Email"
                    ) { email = it }

                    AppTextField(
                        value = password,
                        label = "Password"
                    ) { password = it }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = isSeller,
                            onCheckedChange = { isSeller = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF03A9F4)
                            )
                        )
                        Text("Register as Seller")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    AppButton("Register") {
                        navController.navigate("home")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(onClick = {
                        navController.navigate("login")
                    }) {
                        Text(
                            "Already have an account? Login",
                            color = Color(0xFF0288D1)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        RegisterScreen(navController)
    }
}