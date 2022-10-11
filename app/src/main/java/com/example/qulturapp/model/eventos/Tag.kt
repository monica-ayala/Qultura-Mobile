package com.example.qulturapp.model.eventos

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("id_tag") val id_tag: Int,
    @SerializedName("nom_tag") val nombre_tag: String,
    @SerializedName("id_evento_tag") val id_evento: Int,
    @SerializedName("id_tag_evento") val id_tag_evento: Int,
)
