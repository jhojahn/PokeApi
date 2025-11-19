package com.example.mvvmnavigation.data.models

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    //Importa la anotación @SerializedName, que le dice a Gson (la librería de JSON usada por Retrofit) qué nombre exacto tiene el campo dentro del JSON.
    //Esto es útil cuando el nombre del campo JSON no coincide con el nombre de tu variable en Kotlin.
    @SerializedName("results") var results: ArrayList<Pokemon>
)
