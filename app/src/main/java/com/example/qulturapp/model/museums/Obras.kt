package com.example.qulturapp.model.museums

import com.google.gson.annotations.SerializedName

data class Obras(
    @SerializedName("id_obra") val id_obras: Int,
    @SerializedName("nom_obra") val nom_obra: String,
    @SerializedName("audio_obra") val audio_obra: String,
    @SerializedName("img_obra") val img_obra: String,
    @SerializedName("id_sala") val id_sala: Int,

)
