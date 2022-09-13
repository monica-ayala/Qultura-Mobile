package com.example.qulturapp.model

import com.google.gson.annotations.SerializedName

data class MuseumResults(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String
)
