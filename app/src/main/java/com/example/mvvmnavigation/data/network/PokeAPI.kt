package com.example.mvvmnavigation.data.network

import com.example.mvvmnavigation.data.models.Pokemon
import com.example.mvvmnavigation.data.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface PokeAPI {

    //@Headers → añade cabeceras a la petición (por ejemplo, que acepte JSON).
    @Headers("Accept: application/json")
// Método para obtener todos los pokemon
    @GET("pokemon")//@GET → indica que la llamada será HTTP GET.
    fun getPokemons(): Call<PokemonResponse>     //Call<T> es el tipo de retorno que representa una llamada HTTP que puede ejecutarse (sincronamente o asincronamente).
    // Método para obtener una pokemon por su ID
    @GET("pokemon/{id}")
    //@Path → permite poner valores variables dentro de la URL.
    fun getPokemon(@Path("id") id: Int): Call<Pokemon>
}