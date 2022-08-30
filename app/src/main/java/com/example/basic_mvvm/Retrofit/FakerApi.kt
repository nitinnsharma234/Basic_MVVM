package com.example.basic_mvvm.Retrofit

import com.example.basic_mvvm.Model.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun fetchProducts():Response<List<Products>>



}