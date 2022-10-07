package com.example.qulturapp.model.artwork

import com.google.gson.annotations.SerializedName

data class ArtworkResults(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String,
    @SerializedName("id_obra") val id_obra:Int
)
