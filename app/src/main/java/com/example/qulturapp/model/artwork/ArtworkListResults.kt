package com.example.qulturapp.model.artwork

import com.google.gson.annotations.SerializedName

data class ArtworkListResults(
    @SerializedName("obra") val artwork:List<Obra>
)
