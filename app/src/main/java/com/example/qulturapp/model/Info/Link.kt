package com.example.qulturapp.model.Info

import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("Link") val link: String,
    @SerializedName("nombre_link") val nombre_link: String
)
