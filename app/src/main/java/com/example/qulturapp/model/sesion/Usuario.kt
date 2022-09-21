package com.example.qulturapp.model.sesion

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("id_user") val id: Int,
    @SerializedName("nom_user") val nombre: String,
    @SerializedName("correo_user") val correo: String,
    @SerializedName("password_user") val contrasenia: String,
    @SerializedName("id_rol") val rol: Int
)
