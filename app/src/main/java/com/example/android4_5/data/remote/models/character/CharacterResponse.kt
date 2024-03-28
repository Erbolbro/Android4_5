package com.example.android4_5.data.remote.models.character

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("results")
    val results: List<ResultsItemCharacters>?,
    @SerializedName("info")
    val info: Info
)