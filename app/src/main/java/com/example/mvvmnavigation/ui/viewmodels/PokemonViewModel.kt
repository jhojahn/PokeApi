package com.example.mvvmnavigation.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmnavigation.data.models.Pokemon
import com.example.mvvmnavigation.data.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()

    private val _pokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = _pokemons

    fun fetchPokemons() {
        viewModelScope.launch {
            try {
                // 👉 Ejecutamos la llamada de red en hilo de I/O
                val result = withContext(Dispatchers.IO) {
                    repository.getPokemonList()
                }
                _pokemons.value = result ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
                _pokemons.value = emptyList()
            }
        }
    }
}
