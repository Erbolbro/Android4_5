package com.example.android4_5.data.remote.apiservise

import com.example.android4_5.data.remote.models.character.CharacterResponse
import com.example.android4_5.data.remote.models.location.LocationResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

private const val CHARACTER_END_POINT = "character"
private const val LOCATION_END_POINT = "location"

interface RickAndMortyApi {

    @GET(CHARACTER_END_POINT)
    suspend fun getCharacter():CharacterResponse

    @GET(LOCATION_END_POINT)
    suspend fun getLocation():LocationResponse
}