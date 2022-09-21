package com.example.qulturapp.model.museums

import com.google.gson.annotations.SerializedName

data class Museo(

    @SerializedName("id_museo") val id_museo: Int,
    @SerializedName("nom_museo") val nom_museo: String,
    @SerializedName("desc_museo") val desc_museo: String,
    @SerializedName("ubicacion_museo") val ubicacion_museo: String,
    @SerializedName("link_ubi") val link_ubi: String,
    @SerializedName("num_museo") val num_museo: String,
    @SerializedName("imgP_museo") val imgP_museo: String,
    @SerializedName("imgB_museo") val imgB_museo: String,
    @SerializedName("status") val status: Int

    )
