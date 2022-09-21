package com.example.qulturapp.model.museums

import com.google.gson.annotations.SerializedName

data class MuseumListResults(
    @SerializedName("museos") val museo:List<Museo>,

    )
