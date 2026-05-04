package com.example.hustlemate.navigation

object Routes {

    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val REGISTER = "register"

    const val HOME = "home"

    const val PRODUCT_DETAILS = "product_details/{productId}"

    const val CART = "cart"
    const val CHECKOUT = "checkout"
    const val PAYMENT = "payment"

    // ✅ MUST include orderId
    const val ORDER_CONFIRMATION = "order_confirmation/{orderId}"

    const val MY_ORDERS = "my_orders"

    const val SEARCH = "search"
    const val WISHLIST = "wishlist"

    const val PROFILE = "profile"
    const val EDIT_PROFILE = "edit_profile"
    const val SETTINGS = "settings"
    fun productDetails(productId: String) = "product_details/$productId"
}