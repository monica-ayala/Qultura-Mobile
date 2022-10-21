package com.example.qulturapp.model.sesion

import com.google.gson.annotations.SerializedName

//Data class indica si un usuario fué encontrado en la base de datos
data class EncuentraUsuario(
    @SerializedName("paso") val paso: Int
)
