package com.example.hustlemate.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Cart : BottomNavItem("cart", Icons.Default.ShoppingCart, "Cart")
    object Orders : BottomNavItem("my_orders", Icons.Default.PlayArrow, "Orders")
    object Seller : BottomNavItem("seller_dashboard", Icons.Default.ShoppingCart, "Seller")
}
