package com.example.mvvmnavigation.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mvvmnavigation.ui.screens.InicioScreen
import com.example.mvvmnavigation.ui.screens.LoginScreen
import com.example.mvvmnavigation.ui.screens.RegisterScreen
import com.example.mvvmnavigation.ui.screens.VistaScreen

@Composable
fun NavigationWrapper() {
//encargado de tener toda la navegación
    val navController = rememberNavController()
//donde estarán todas las rutas que utilizará nuestra app
    NavHost(navController= navController, startDestination = Inicio){
//declaramos la vista login, entre <> va el nombre del objeto de Screens.kt
        composable<Login> {
//para pasar la funcionalidad del boton que hay en la pantalla,mandamos una Lambda
//si la lambda es lo último (o lo único que se manda) podemos poner directamente paréntesis en lugar de llaves!
            /*
            //esto da error porque LoginScreen esperaba parametros no una lamda directamente
            sin asociar a ningun paramentro
            LoginScreen() {navController.navigate(Vista(email,pass))}
             */
            LoginScreen(
                //le paso esta funcion lamda para que cuando se necesario vaya a la vista
                NavigateToVista = { email, pass -> navController.navigate(Vista(email, pass)) },
                //le pasamos tambien NavigateToRegistro para que al cambiar cuando haya que cambiar al registro
                //la pantalla de login no lo haga directamente sino que llama a la funcion que le fue pasada por el controlador
                NavigateToRegistro = { navController.navigate(Registro) }
            )
        }
        composable<Inicio> {
            InicioScreen({ navController.navigate(Login)}
                , { navController.navigate(Registro)})
        }
        composable<Registro> {
            //esta no da error porque la pantalla registrar solo espera una lamda sin parametros
            RegisterScreen(){navController.navigate(Login)}
        }
//si queremos mandar un dato a la vista, necesitamos el NavBackStackEntry de la ruta
        composable<Vista> {
            val vista = it.toRoute<Vista>() //cogemos el object vista
/*podemos pasar el parámetro nombre y la lambda, si tuviéramos más parámetros,
bastaría con poner el nombre de cada uno seguido de un = y el valor*/
            VistaScreen(vista.email, pass = vista.pass){navController.navigate(Login) {
//volveríamos a Inicio, quitando del stack del navigation lo anterior (para cerrar sesión por ejemplo)
                popUpTo<Login>{inclusive=true}
                }
            }
        }
    }
}