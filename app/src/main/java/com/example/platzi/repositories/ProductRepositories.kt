package com.example.platzi.repositories

import com.example.platzi.network.ApiService
import javax.inject.Inject

class ProductRepositories @Inject constructor(val apiService: ApiService) {

    suspend fun getAllProductRepo()= apiService.getAllProducts()


}