package com.example.qulturapp.solicitudes

import com.google.gson.annotations.SerializedName

data class Solicitud(
    @SerializedName("museo") val museo: String,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("asistentes") val asistentes: Int,
    @SerializedName("estado") val estado: Int
)
