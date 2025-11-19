package com.example.mvvmnavigation.data.repository

import com.example.mvvmnavigation.data.models.Pokemon
import com.example.mvvmnavigation.data.network.RetrofitClient

class PokemonRepository {
    private val api = RetrofitClient.pokeAPI

    suspend fun getPokemonList() : ArrayList<Pokemon>?{
        val call = api.getPokemons().execute()
        val body = call.body()
        if(call.isSuccessful){
            return body?.results
        }else {
            return ArrayList<Pokemon>()
        }
    }
}
