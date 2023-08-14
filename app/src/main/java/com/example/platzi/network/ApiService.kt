package com.example.platzi.network

import com.example.platzi.data.models.product.ProductResponse
import com.example.platzi.data.models.product.ProductResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getAllProducts():Response<ProductResponse>

}