package com.example.android4_5.data.remote.models.location

import com.google.gson.annotations.SerializedName

data class LocationResponse(@SerializedName("results")
                            val results: List<ResultsItemLocation>?,
                            @SerializedName("info")
                            val info: Info)