package com.example.hustlemate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

import com.example.hustlemate.ui.theme.Customers.*
import com.example.hustlemate.ui.theme.auth.*
import com.example.hustlemate.ui.theme.core.SplashScreen
import androidx.navigation.compose.composable
import com.example.hustlemate.ui.theme.Customers.CartScreen

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {

        composable(Routes.SPLASH) { SplashScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.REGISTER) { RegisterScreen(navController) }

        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.CART) { CartScreen(navController) }
        composable(Routes.PAYMENT) { PaymentScreen(navController) }

        // ✅ FIXED: declare argument
        composable(
            route = Routes.ORDER_CONFIRMATION,
            arguments = listOf(
                navArgument("orderId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val orderId =
                backStackEntry.arguments?.getString("orderId") ?: ""

            OrderConfirmationScreen(orderId, navController)
        }

        composable(Routes.MY_ORDERS) { MyOrdersScreen() }
    }
}