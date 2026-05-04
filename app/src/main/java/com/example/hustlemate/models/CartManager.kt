package com.example.hustlemate.data.models

object CartManager {

    data class Item(val name: String, val price: Double)

    private val items = mutableListOf<Item>()

    fun addItem(item: Item) {
        items.add(item)
    }

    fun getItems(): List<Item> = items

    fun getTotal(): Double = items.sumOf { it.price }

    fun clear() {
        items.clear()
    }
}