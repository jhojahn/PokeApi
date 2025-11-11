package com.example.mvvmnavigation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmnavigation.R

@Composable
fun InicioScreen(NavigateToLogin: () -> Unit, NavigateToRegistro: () -> Unit) {

    Surface(
        color = Color(0xFFDFFFD6),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título principal
            Text(
                text = "CARTERA DE\nPOKÉMONS",
                color = Color.Blue,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Imagen principal (usa el recurso que tengas, por ejemplo R.drawable.descarga)
            Image(
                painter = painterResource(id = R.drawable.poke),
                contentDescription = "Grupo Pokémon",
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de iniciar sesión
            Button(
                onClick = { NavigateToLogin() },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Iniciar sesión")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de registrarse
            Button(
                onClick = { NavigateToRegistro() },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Regístrate")
            }
        }
    }
}

@Preview
@Composable
fun preview(){
    Text("abkljfbkjas")
}