package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class Solicitud_Necesidad(
    @SerializedName("id_solicitud_necesidad") val id_solicitud: Int,
    @SerializedName("id_necesidad_solicitud") val id_necesidad: Int
)
