package com.example.android4_5.data.remote.models.character

import com.google.gson.annotations.SerializedName

data class Origin(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = ""
)