package com.example.qulturapp.model.solicitudes

import com.google.gson.annotations.SerializedName

data class SolicitudListResults(
    @SerializedName("museos") val solicitudes:List<Solicitud>,
    @SerializedName("necesidades") val necesidades:List<Necesidad>,
    @SerializedName("solicitud_necesidades") val solicitud_necesidades:List<Solicitud_Necesidad>,
)
