package com.example.platzi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzi.data.models.product.ProductResponseItem
import com.example.platzi.repositories.ProductRepositories
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltAndroidApp
class ProductViewModel @Inject constructor(val repositories: ProductRepositories) : ViewModel() {
    //write only from product view model
    private val _allProducts: MutableLiveData<ProductResponseItem> = MutableLiveData()

    val allProducts: LiveData<ProductResponseItem> = _allProducts


    ///////////////
    init {
        getAllProductVM()
    }

    //////////////

    fun getAllProductVM() {
        viewModelScope.launch {
            val response = repositories.getAllProductRepo()

            if (response.isSuccessful) {
                _allProducts.postValue(response.body())

            }


        }

    }

}