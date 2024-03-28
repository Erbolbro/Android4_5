package com.example.android4_5.data.repositories

import android.util.Log
import com.example.android4_5.data.remote.apiservise.RickAndMortyApi
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RickAndMortyRepositories @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
) {
    suspend fun getCharacter() = rickAndMortyApi.getCharacter()

    suspend fun getLocation() = rickAndMortyApi.getLocation()
}