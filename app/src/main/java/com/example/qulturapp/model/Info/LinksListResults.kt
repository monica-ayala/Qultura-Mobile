package com.example.qulturapp.model.Info

import com.google.gson.annotations.SerializedName

data class LinksListResults(
    @SerializedName("links") val links: List<Link>
)
