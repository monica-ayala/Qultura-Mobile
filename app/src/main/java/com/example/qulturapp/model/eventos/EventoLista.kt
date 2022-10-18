package com.example.qulturapp.model.eventos

import com.google.gson.annotations.SerializedName

data class EventoLista(
    val id_evento: Int,
    val info_evento: String,
    val fecha_evento: String,
    val multimedia_evento: String,
    val ubicacion_evento: String,
    val tags: List<String>
)
