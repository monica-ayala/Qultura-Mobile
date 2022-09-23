package com.example.qulturapp.model.Info

import com.google.gson.annotations.SerializedName

data class Guia(
    @SerializedName("name") val name: String,
    @SerializedName("description") val desc: String,
    @SerializedName("tip") val tip: String
)
