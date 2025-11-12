package com.example.mvvmnavigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.mvvmnavigation.ui.viewmodels.PokemonViewModel

@Composable
fun VistaScreen(
    email: String,
    pass: String,
    NavigateToLogin: () -> Unit,
    viewModel: PokemonViewModel = viewModel()
) {
    val pokemons by viewModel.pokemons.collectAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchPokemons()
    }

    Surface(color = Color(0xFFDFFFD6), modifier = Modifier.fillMaxSize()) {
        if (pokemons.isEmpty()) {
            // 🔄 Mostrar cargando si la lista aún no llegó
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Blue)
            }
        } else {
            LazyColumn(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text("¡Hola, $email!", style = MaterialTheme.typography.titleLarge, color = Color.Blue)
                    Spacer(Modifier.height(8.dp))
                    Text("Lista de Pokémon:", style = MaterialTheme.typography.bodyLarge)
                    Spacer(Modifier.height(20.dp))
                }

                items(pokemons) { pokemon ->
                    val id = pokemons.indexOf(pokemon).takeIf { it >= 0 }?.plus(1) ?: 0
                    val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = pokemon.getNombre(),
                            modifier = Modifier.size(120.dp)
                        )
                        Text(pokemon.getNombre(), color = Color.DarkGray)
                        Spacer(Modifier.height(16.dp))
                    }
                }

                item {
                    Spacer(Modifier.height(24.dp))
                    Button(onClick = { NavigateToLogin() }) {
                        Text("Cerrar sesión")
                    }
                }
            }
        }
    }
}
