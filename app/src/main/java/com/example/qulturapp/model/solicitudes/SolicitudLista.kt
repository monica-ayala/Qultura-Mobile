package com.example.qulturapp.model.solicitudes

data class SolicitudLista(
    val id_solicitud: Int,
    val info_adicional: String,
    val fecha: String,
    val asistentes: Int,
    val estado: Int,
    val museo: String,
    val imagen_museo: String,
    val necesidades: List<String>
)
