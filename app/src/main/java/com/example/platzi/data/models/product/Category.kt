package com.example.platzi.data.models.product


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("creationAt")
    var creationAt: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("updatedAt")
    var updatedAt: String?
)