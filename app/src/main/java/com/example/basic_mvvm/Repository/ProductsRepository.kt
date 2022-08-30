package com.example.basic_mvvm.Repository

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.basic_mvvm.Model.Products
import com.example.basic_mvvm.Retrofit.FakerApi
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val fakerApi:FakerApi) {

    var list:List<Products> = listOf()

    suspend fun getInstance(): List<Products>{
        val result=fakerApi.fetchProducts()
        if(result.isSuccessful)
        {
            list = result.body()!!
            Log.d("TAG", "getInstance: ${list}")
        }
        return list
    }
}