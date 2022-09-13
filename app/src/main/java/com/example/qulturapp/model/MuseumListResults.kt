package com.example.qulturapp.model

import com.google.gson.annotations.SerializedName

data class MuseumListResults(
    @SerializedName("museos") val museo:List<Museo>,

    )
