package com.example.qulturapp.model.artwork

import com.google.gson.annotations.SerializedName

data class ArtworkListResults(
    @SerializedName("obras") val artwork:List<Obra>
)
