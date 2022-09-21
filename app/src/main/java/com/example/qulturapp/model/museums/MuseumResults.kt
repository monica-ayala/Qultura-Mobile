package com.example.qulturapp.model.museums

import com.google.gson.annotations.SerializedName

data class MuseumResults(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String
)
