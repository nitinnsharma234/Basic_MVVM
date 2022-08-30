package com.example.basic_mvvm.Model

data class Products(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)

val BASE_URL="https://fakestoreapi.com/"