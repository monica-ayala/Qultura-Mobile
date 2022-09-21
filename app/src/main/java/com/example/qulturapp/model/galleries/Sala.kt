package com.example.qulturapp.model.galleries

import com.google.gson.annotations.SerializedName

data class Sala(

    @SerializedName("id_sala") val id_sala: Int,
    @SerializedName("nom_sala") val nom_sala: String,
    @SerializedName("audio_sala") val audio_sala: String,
    @SerializedName("desc_sala") val desc_sala: String,
    @SerializedName("img_sala") val img_sala: String,
    @SerializedName("status_sala") val status_sala: Int,
    @SerializedName("id_museo_sala") val id_museo_sala: Int

)
