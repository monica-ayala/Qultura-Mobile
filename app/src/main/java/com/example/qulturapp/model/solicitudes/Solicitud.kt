package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class Solicitud(
    @SerializedName("museo") val museo: String,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("asistentes") val asistentes: Int,
    @SerializedName("estado") val estado: Int,
    @SerializedName("necesidades") val necesidades: List<String>
)
