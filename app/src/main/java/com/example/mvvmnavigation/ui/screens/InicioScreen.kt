package com.example.mvvmnavigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InicioScreen(NavigateToLogin: () -> Unit, NavigateToRegistro: () -> Unit) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Inicio")

            Button(onClick = { NavigateToLogin() } ) {
                Text("Ir a Login")
            }
            Button(onClick = { NavigateToRegistro() } ) {
                Text("Ir a registro")
            }
        }


    }
}

@Preview
@Composable
fun preview(){
    Text("abkljfbkjas")
}