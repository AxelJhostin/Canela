package com.negocio.canela.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.negocio.canela.ViewModel.LoginAdministradorViewModel
import com.negocio.canela.ViewModel.LoginUsuarioViewModel
import com.negocio.canela.Vistas.InicioAdministrador
import com.negocio.canela.Vistas.InicioUsuario
import com.negocio.canela.Vistas.LogoInicial
import com.negocio.canela.Vistas.PantInicial
import com.negocio.canela.Vistas.RegistroUsuario
import com.negocio.canela.Vistas.VistaAdministrador
import com.negocio.canela.Vistas.VistaUsuario

@Composable
fun Navegacion(loginUsuario: LoginUsuarioViewModel,loginAdministrador: LoginAdministradorViewModel){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "LogoInicial"
    ) {
        composable("LogoInicial") {
            LogoInicial(navController)
        }
        composable("PantInicial") {
            PantInicial(navController)
        }
        composable("InicioUsuario"){
            InicioUsuario(navController,loginUsuario)
        }
        composable("RegistroUsuario") {
            RegistroUsuario(navController,loginUsuario)
        }
        composable("InicioAdministrador") {
            InicioAdministrador(navController,loginAdministrador)
        }
        composable("VistaUsuario") {
            VistaUsuario(navController,loginUsuario)
        }
        composable("VistaAdministrador") {
            VistaAdministrador(navController)
        }
    }
}