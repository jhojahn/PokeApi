package com.example.mvvmnavigation.core.navigation

import kotlinx.serialization.Serializable
//si no mandamos parámetros a la pantalla podemos usar objetos
//Cada object representa una pantalla única (un singleton).
//Se marca con @Serializable para que el sistema de navegación pueda identificarla.
//No necesitan parámetros porque solo indican la ruta (“quiero ir al Login”, “quiero ir al Registro”, etc.).
@Serializable //permite convertir un objeto o clase en una forma que puede viajar por la navegación (como si fuera un JSON).
object Login
@Serializable
object Registro
@Serializable
object Inicio
//si queremos mandar parámetros necesitamos una data class
@Serializable
data class Vista(val email : String, val pass : String)
//si necesitamos pasar algo más pesado, un objeto, un array, lo hacemos pasando id y utilizando sharedPrefs