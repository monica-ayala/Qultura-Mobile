package com.example.qulturapp.model.galleries

import com.google.gson.annotations.SerializedName

data class GalleryListResults (
    @SerializedName("salas") val gallery:List<Sala>
    )
