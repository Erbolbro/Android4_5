package com.example.android4_5.data.remote.models.location

import com.google.gson.annotations.SerializedName

data class ResultsItemLocation(
    @SerializedName("created")
    val created: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("residents")
    val residents: List<String>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("dimension")
    val dimension: String = "",
    @SerializedName("url")
    val url: String = ""
)