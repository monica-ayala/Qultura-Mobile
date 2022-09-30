package com.example.qulturapp.model.Info

import com.google.gson.annotations.SerializedName

data class GuiasListResults(
    @SerializedName("guias") val guias: List<Guia>
)