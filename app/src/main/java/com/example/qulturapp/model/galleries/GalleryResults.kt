package com.example.qulturapp.model.galleries

import com.google.gson.annotations.SerializedName

data class GalleryResults(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String
)
