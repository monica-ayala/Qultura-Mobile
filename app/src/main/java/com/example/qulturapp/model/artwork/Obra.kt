package com.example.qulturapp.model.artwork

import com.google.gson.annotations.SerializedName

data class Obra(

    @SerializedName("id_obra") val id_obra: Int,
    @SerializedName("nom_obra") val nom_obra: String,
    @SerializedName("audio_obra") val audio_obra: String,
    @SerializedName("subtitulo_obra") val subtitulo_obra: String,
    @SerializedName("img_obra") val img_obra: String,
    @SerializedName("fecha_obra") val fecha_obra: String,
    @SerializedName("autor_obra") val autor_obra: String,
    @SerializedName("desc_obra") val desc_obra: String,
    @SerializedName("id_sala") val id_sala: Int
    )
