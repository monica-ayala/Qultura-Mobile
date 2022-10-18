package com.example.qulturapp.model.sesion

import com.google.gson.annotations.SerializedName

data class TokenResult(
    @SerializedName("accessToken") val token: String
)
