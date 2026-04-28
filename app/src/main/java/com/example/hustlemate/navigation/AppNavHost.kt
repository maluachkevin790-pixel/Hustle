package com.hustlemate.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

// Import screens
import com.hustlemate.app.screens.*

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ) {

        // 🔐 Auth
        composable(Routes.Login.route) {
            LoginScreen(navController)
        }

        composable(Routes.Register.route) {
            RegisterScreen(navController)
        }

        // 🛍️ Customer
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }

        composable(
            route = Routes.ProductDetails.route,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailsScreen(navController, productId!!)
        }

        composable(Routes.Cart.route) {
            CartScreen(navController)
        }

        composable(Routes.Checkout.route) {
            CheckoutScreen(navController)
        }

        composable(
            route = Routes.OrderConfirmation.route,
            arguments = listOf(navArgument("orderId") { type = NavType.StringType })
        ) { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")
            OrderConfirmationScreen(navController, orderId!!)
        }

        composable(Routes.MyOrders.route) {
            MyOrdersScreen(navController)
        }

        // 🧑‍💼 Seller
        composable(Routes.SellerDashboard.route) {
            SellerDashboardScreen(navController)
        }

        composable(Routes.AddProduct.route) {
            AddProductScreen(navController)
        }
    }
}