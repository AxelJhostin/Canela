package com.negocio.canela.Vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.negocio.canela.Componentes.BotonBasico
import com.negocio.canela.Componentes.EspacioV
import com.negocio.canela.Componentes.IngresarTexto
import com.negocio.canela.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioAdministrador(navController: NavController) {
    // Variables de entrada
    var correo by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }

    // Variables de error
    var errorCorreo by remember { mutableStateOf(false) }
    var errorContrasenia by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Iniciar Sesión", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(8, 76, 3) // Color de la barra superior
                )
            )
        },
        containerColor = Color(8, 76, 3) // Fondo de la pantalla
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()), // Habilita desplazamiento
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo de la aplicación - Mayor separación arriba
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), // Hace que el logo ocupe más espacio y no quede arriba
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logooficial),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(230.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Fit
                )
                EspacioV(15)
                Text("Administrador :)", fontSize = 45.sp, color = Color.White)
            }

            // Formulario de inicio de sesión
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .weight(1f), // Hace que el formulario quede más abajo y bien distribuido
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IngresarTexto(
                    label = "Correo",
                    placeholder = "Ingrese su correo",
                    value = correo,
                    onValueChange = {
                        correo = it
                        errorCorreo = it.isEmpty()
                    },
                    isError = errorCorreo,
                    errorMessage = "Ingrese su correo por favor"
                )

                EspacioV(12)

                IngresarTexto(
                    label = "Contraseña",
                    placeholder = "Ingrese su contraseña",
                    value = contrasenia,
                    onValueChange = {
                        contrasenia = it
                        errorContrasenia = it.isEmpty()
                    },
                    isError = errorContrasenia,
                    errorMessage = "Ingrese su contraseña por favor"
                )

                EspacioV(24)

                // Botón para iniciar sesión
                BotonBasico(texto = "Iniciar Sesión", tamanio = 20) {
                    // Aquí iría la lógica de autenticación
                }

                EspacioV(30) // Espacio al final para evitar que el botón quede pegado abajo
            }
        }
    }
}

