package com.example.qulturapp.model.eventos

import com.google.gson.annotations.SerializedName

data class EventoListResults(
    @SerializedName("eventos") val eventos: List<Evento>,
    @SerializedName("tags") val tags: List<Tag>
)
