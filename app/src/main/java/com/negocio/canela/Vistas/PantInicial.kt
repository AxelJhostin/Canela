package com.negocio.canela.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.negocio.canela.Componentes.BotonBasico
import com.negocio.canela.Componentes.EspacioH
import com.negocio.canela.Componentes.EspacioV
import com.negocio.canela.Componentes.RedesSocialesCuadro
import com.negocio.canela.R

@Composable
fun PantInicial(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(8, 76, 3)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Logo de la aplicación
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logooficial),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
            )
        }

        // Botones de ingreso y registro
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                BotonBasico(texto = "Ingresar", tamanio = 20) { }
                EspacioH(10)
                BotonBasico(texto = "Registrarse", tamanio = 20) {
                    navController.navigate("RegistroUsuario")
                }
            }
        }

        // Redes sociales (más separación de los botones)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            RedesSocialesCuadro { }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPantInicial() {
    val navController = rememberNavController()
    PantInicial(navController)
}
