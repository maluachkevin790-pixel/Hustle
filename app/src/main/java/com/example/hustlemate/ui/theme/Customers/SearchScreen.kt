package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.ui.theme.*

@Composable
fun SearchScreen(navController: NavController) {
    var query by remember { mutableStateOf("") }

    SearchContent(
        query = query,
        onQueryChange = { query = it }
    )
}

// ----------------------
// UI CONTENT (PREVIEWABLE)
// ----------------------
@Composable
fun SearchContent(
    query: String,
    onQueryChange: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            text = "Search",
            style = MaterialTheme.typography.headlineMedium,
            color = SkyBlueDark
        )

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            label = { Text("Search products") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = SkyBlueDark,
                focusedLabelColor = SkyBlueDark,
                cursorColor = SkyBlueDark
            )
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Results for:",
            style = MaterialTheme.typography.titleMedium,
            color = TextSecondary
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = query.ifEmpty { "Nothing yet..." },
            style = MaterialTheme.typography.bodyLarge,
            color = TextPrimary
        )
    }
}

// ----------------------
// PREVIEW
// ----------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreenPreview() {

    HustleMateTheme {
        SearchContent(
            query = "Sneakers",
            onQueryChange = {}
        )
    }
}