package com.hustlemate.app.model

data class Payment(
    val orderId: String = "",
    val method: String = "",
    val status: String = "Pending",
    val transactionId: String? = null
)