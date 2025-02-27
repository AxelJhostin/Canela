package com.negocio.canela.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.negocio.canela.Vistas.LogoInicial
import com.negocio.canela.Vistas.PantInicial

@Composable
fun Navegacion(){
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
    }
}