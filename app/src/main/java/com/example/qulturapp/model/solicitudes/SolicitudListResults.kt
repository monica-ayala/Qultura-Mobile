package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class SolicitudListResults(
    @SerializedName("solicitudes") val solicitudes:List<Solicitud>,
    @SerializedName("necesidades") val necesidades:List<Necesidad>
)
