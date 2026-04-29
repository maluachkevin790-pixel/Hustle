package com.example.hustlemate.data

import com.example.hustlemate.models.Product

fun getSampleProducts(): List<Product> {
    return listOf(
        Product("1", "Shoes", 2500.0, "Nice running shoes"),
        Product("2", "Phone", 15000.0, "Android smartphone"),
        Product("3", "Bag", 1200.0, "Leather bag")
    )
}