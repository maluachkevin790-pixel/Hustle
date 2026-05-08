package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

import com.example.hustlemate.data.models.Product
import com.example.hustlemate.ui.theme.*
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun CategoryProductsScreen(

    navController: NavController,

    categoryName: String
) {

    val db = FirebaseFirestore.getInstance()

    var products by remember {
        mutableStateOf(listOf<Product>())
    }

    LaunchedEffect(Unit) {

        db.collection("products")
            .whereEqualTo(
                "category",
                categoryName
            )
            .addSnapshotListener { snapshot, _ ->

                if (snapshot != null) {

                    products =
                        snapshot.documents.mapNotNull { doc ->

                            Product(
                                id = doc.id,
                                name =
                                    doc.getString("name")
                                        ?: "",

                                description =
                                    doc.getString("description")
                                        ?: "",

                                price =
                                    doc.getDouble("price")
                                        ?: 0.0,

                                imageUrl =
                                    doc.getString("imageUrl")
                                        ?: "",

                                category =
                                    doc.getString("category")
                                        ?: ""
                            )
                        }
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(12.dp)
    ) {

        Text(
            text = categoryName,
            style =
                MaterialTheme.typography.headlineMedium,
            color = SkyBlueDark
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),

            verticalArrangement =
                Arrangement.spacedBy(12.dp),

            horizontalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            items(products) { product ->

                Card(
                    shape = RoundedCornerShape(16.dp),

                    elevation =
                        CardDefaults.cardElevation(4.dp),

                    modifier = Modifier.clickable {

                        navController.navigate(
                            "product_details/${product.id}"
                        )
                    }
                ) {

                    Column {

                        AsyncImage(
                            model = product.imageUrl,

                            contentDescription = null,

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp),

                            contentScale =
                                ContentScale.Crop
                        )

                        Column(
                            modifier =
                                Modifier.padding(10.dp)
                        ) {

                            Text(product.name)

                            Spacer(
                                modifier =
                                    Modifier.height(6.dp)
                            )

                            Text(
                                text =
                                    "KES ${product.price}",

                                color = SkyBlueDark
                            )
                        }
                    }
                }
            }
        }
    }
}
