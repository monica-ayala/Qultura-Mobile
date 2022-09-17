package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class Necesidad(
    @SerializedName("id_necesidad") val id_necesidad: Int,
    @SerializedName("necesidad") val necesidad: String,
)
