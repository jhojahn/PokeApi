package com.example.mvvmnavigation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmnavigation.ui.viewmodels.LoginViewModel

@Composable     //el viewModel guarda el estado de la pantalla y se comunica
                //con los repositorios de firebase y api, y no depende la intefaz
fun LoginScreen(viewModel: LoginViewModel = viewModel(),
                NavigateToVista: (String, String) -> Unit,
                NavigateToRegistro: () -> Unit) {
    val context = LocalContext.current
    //cuando su valor cambia, las partes de la interfaz que lo observan se sctualizan automaticamente
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val isLoading by viewModel.isLoading.observeAsState(false)
    val errorMessage by viewModel.errorMessage.observeAsState()
    val isLoginOk by viewModel.isLoginOk.observeAsState(false)
    //var email by remember { mutableStateOf("") }
    //var pass by remember { mutableStateOf("") }

    LaunchedEffect(isLoginOk) {
        if (isLoginOk) {
            NavigateToVista(email, password)
        }
    }

    Surface(color = Color(0xFFDFFFD6), modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("LOGIN", style = MaterialTheme.typography.headlineMedium, color = Color.Blue)
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = email,
                onValueChange = viewModel::onEmailChange,
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = password,
                onValueChange = viewModel::onPasswordChange,
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { viewModel.onLogin() }, enabled = !isLoading) {
                Text("Acceder")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { NavigateToRegistro() }) {
                Text("Registrarse")
            }

            if (isLoading) {
                Spacer(Modifier.height(16.dp))
                CircularProgressIndicator()
            }

            errorMessage?.let {
                Spacer(Modifier.height(16.dp))
                Text(it, color = Color.Red)
            }
        }
    }
}
