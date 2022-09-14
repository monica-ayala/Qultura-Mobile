package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class SolicitudListResults(
    @SerializedName("museos") val solicitudes:List<Solicitud>,
)
