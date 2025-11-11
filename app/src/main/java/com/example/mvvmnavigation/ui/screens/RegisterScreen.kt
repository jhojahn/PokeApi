package com.example.mvvmnavigation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmnavigation.ui.viewmodels.RegisterViewModel

@Composable
fun RegisterScreen(viewModel: RegisterViewModel = viewModel(),
                   NavigateToLogin:()->Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

    Surface(color = Color(0xFFDFFFD6), modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("REGISTRO", style = MaterialTheme.typography.headlineMedium, color = Color.Blue)
            Spacer(Modifier.height(20.dp))

            TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
            Spacer(Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.height(24.dp))

            Button(onClick = {
                if (email.isBlank() || password.isBlank()) {
                    message = "Rellena todos los campos"
                    return@Button
                }
                viewModel.register(email, password) { ok, msg ->
                    message = msg ?: if (ok) "Usuario registrado correctamente" else "Error desconocido"
                    if (ok) NavigateToLogin()
                }
            }) {
                Text("Registrar")
            }

            Spacer(Modifier.height(20.dp))
            Button(onClick = NavigateToLogin) { Text("Volver") }

            message?.let {
                Spacer(Modifier.height(16.dp))
                Text(it, color = if (it.contains("correctamente")) Color.Green else Color.Red)
            }
        }
    }
}