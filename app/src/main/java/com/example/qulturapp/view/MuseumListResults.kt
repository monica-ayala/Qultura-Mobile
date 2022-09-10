package com.example.qulturapp.view

import com.google.gson.annotations.SerializedName

data class MuseumListResults(
    @SerializedName("museos") val museo:List<Museo>,

)
