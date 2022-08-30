package com.example.basic_mvvm.ViewModel

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basic_mvvm.Model.Products
import com.example.basic_mvvm.Repository.ProductsRepository
import kotlinx.coroutines.launch


class MainViewModel (val repository: ProductsRepository):ViewModel() {

    private var _productList= mutableStateListOf<Products>()
    val product:List<Products>
        get() =_productList

    var errorMessage: String by mutableStateOf("")



    fun fetchRepo(){
        viewModelScope.launch {
            try {
                _productList.addAll(repository.getInstance())
                Log.d("TAG", "getInstance: ${_productList.size}")
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }
}