package com.example.hustlemate.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.example.hustlemate.ui.theme.Customers.*
import com.example.hustlemate.ui.theme.auth.LoginScreen
import com.example.hustlemate.ui.theme.auth.RegisterScreen
import com.example.hustlemate.ui.theme.core.SplashScreen
import com.example.hustlemate.ui.theme.profille.EditProfileScreen
import com.example.hustlemate.ui.theme.profille.ProfileScreen
import com.example.hustlemate.ui.theme.profille.SettingsScreen
import com.example.hustlemate.viewmodel.CartViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    val cartViewModel: CartViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        // 🔹 AUTH
        composable(Routes.SPLASH) {
            SplashScreen(navController)
        }

        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        composable(Routes.REGISTER) {
            RegisterScreen(navController)
        }

        // 🔹 CUSTOMER FLOW
        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        composable(Routes.SEARCH) {
            SearchScreen(navController)
        }

        composable(Routes.WISHLIST) {
            WishlistScreen(navController)
        }

        composable(Routes.CART) {
            CartScreen(cartViewModel = cartViewModel)
        }

        composable(Routes.CHECKOUT) {
            CheckoutScreen(navController)
        }

        composable(Routes.PAYMENT) {
            PaymentScreen(navController)
        }

        composable(Routes.ORDER_CONFIRMATION) {
            OrderConfirmationScreen(navController, "123")
        }

        // 🔥 PRODUCT DETAILS
        composable(
            route = Routes.PRODUCT_DETAILS,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailsScreen(
                navController = navController,
                productId = productId,
                cartViewModel = cartViewModel
            )
        }

        // 🔹 PROFILE
        composable(Routes.PROFILE) {
            ProfileScreen(navController)
        }

        composable(Routes.EDIT_PROFILE) {
            EditProfileScreen(navController)
        }

        composable(Routes.SETTINGS) {
            SettingsScreen(navController)
        }
    }
}
