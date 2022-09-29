package com.example.qulturapp.model.Info

import com.google.gson.annotations.SerializedName

data class Guia(
    @SerializedName("name") val name: String,
    @SerializedName("description") val desc: String,
    @SerializedName("tip") val tip: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("imagen") val imagen: String,
    @SerializedName("video") val video: String
)
