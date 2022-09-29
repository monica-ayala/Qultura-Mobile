package com.example.qulturapp.model.museums

import com.google.gson.annotations.SerializedName

data class ObraListResult(@SerializedName("obras") val obras:List<Obras>)
