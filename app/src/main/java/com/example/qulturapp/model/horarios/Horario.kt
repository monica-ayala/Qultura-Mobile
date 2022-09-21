package com.example.qulturapp.model.horarios

import com.google.gson.annotations.SerializedName

data class Horario (
    @SerializedName("hora") val hora: String
)