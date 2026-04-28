package com.hustlemate.app.navigation
sealed class Routes(val route: String) {

    // Auth
    object Login : Routes("login")
    object Register : Routes("register")

    // Customer
    object Home : Routes("home")
    object ProductDetails : Routes("product_details/{productId}") {
        fun createRoute(productId: String) = "product_details/$productId"
    }
    object Cart : Routes("cart")
    object Checkout : Routes("checkout")
    object OrderConfirmation : Routes("order_confirmation/{orderId}") {
        fun createRoute(orderId: String) = "order_confirmation/$orderId"
    }
    object MyOrders : Routes("my_orders")

    // Seller
    object SellerDashboard : Routes("seller_dashboard")
    object AddProduct : Routes("add_product")
}
