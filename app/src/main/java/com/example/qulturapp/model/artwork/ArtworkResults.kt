package com.example.qulturapp.model.artwork

import com.google.gson.annotations.SerializedName

data class ArtworkResults(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String,
    @SerializedName("id_obra") val id_obra:Int,
    @SerializedName("desc_obra") val desc_obra: String,
    @SerializedName("fecha_obra") val fecha_obra: String,
    @SerializedName("autor_obra") val autor_obra: String,
)
