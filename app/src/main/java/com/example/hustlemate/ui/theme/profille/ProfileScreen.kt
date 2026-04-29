package com.example.hustlemate.ui.theme.profille

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.HustleMateTheme

@Composable
fun ProfileScreen(navController: NavController) {
    Column(Modifier.padding(16.dp)) {
        Text("Profile", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        Text("Name: User", fontSize = 18.sp)
        Text("Email: user@email.com", fontSize = 16.sp)

        Spacer(Modifier.height(24.dp))

        AppButton("Edit Profile") {
            navController.navigate(Routes.EDIT_PROFILE)
        }

        AppButton("Settings") {
            navController.navigate(Routes.SETTINGS)
        }

        AppButton("Logout") {
            navController.navigate(Routes.LOGIN) {
                popUpTo(Routes.HOME) { inclusive = true }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        ProfileScreen(navController)
    }
}
