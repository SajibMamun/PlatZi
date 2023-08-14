package com.example.platzi.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.platzi.data.models.product.ProductResponse
import com.example.platzi.data.models.product.ProductResponseItem
import com.example.platzi.repositories.ProductRepositories
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(val repositories: ProductRepositories) : ViewModel() {
    //write only from product view model
    private val _allProducts: MutableLiveData<ProductResponse> = MutableLiveData()

    val allProducts: LiveData<ProductResponse> = _allProducts


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