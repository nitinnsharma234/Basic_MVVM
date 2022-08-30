package com.example.basic_mvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basic_mvvm.Repository.ProductsRepository
import javax.inject.Inject

class MainViewmodelFactory @Inject constructor(private  val repository: ProductsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}