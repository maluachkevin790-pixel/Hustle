package com.hustlemate.app.model

data class Order(
    val id: String = "",
    val userId: String = "",
    val items: List<CartItem> = emptyList(),
    val totalAmount: Double = 0.0,
    val paymentMethod: String = "", // mpesa, paypal, cash
    val status: String = "Pending"
)