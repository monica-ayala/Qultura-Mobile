package com.example.qulturapp.model.sesion

import com.google.gson.annotations.SerializedName

data class UsuarioListResults(
    @SerializedName("usuario") val usuarios:List<Usuario>,
)
