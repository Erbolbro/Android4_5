package com.example.android4_5.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4_5.data.remote.models.character.ResultsItemCharacters
import com.example.android4_5.data.remote.models.location.ResultsItemLocation
import com.example.android4_5.data.repositories.RickAndMortyRepositories
import com.example.android4_5.ui.model.CharacterAndLocationResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickAndMortyViewModel @Inject constructor(
    private val repositories: RickAndMortyRepositories
) : ViewModel() {
    private var _locationCharacter = MutableLiveData<List<CharacterAndLocationResponse>>()
    val locationCharacter: LiveData<List<CharacterAndLocationResponse>> = _locationCharacter

    init {
        getModel()
    }

    fun getModel() {
        viewModelScope.launch {
            val characters = async { repositories.getCharacter() }
            val location = async { repositories.getLocation() }
            connectList(characters.await().results!!, location.await().results!!)
        }
    }

    private fun connectList(
        characterList: List<ResultsItemCharacters>, locationList: List<ResultsItemLocation>
    ) {
        val combinedList = characterList.zip(locationList).map { (character) ->
            CharacterAndLocationResponse(
                character.name,
                character.location.name,
                character.image
            )
        }
        _locationCharacter.value = combinedList
    }
}