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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.negocio.canela.Componentes.BotonBasico
import com.negocio.canela.Componentes.EspacioV
import com.negocio.canela.Componentes.IngresarTexto
import com.negocio.canela.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroUsuario(navController: NavController) {
    // Variables donde van los datos de usuario
    var correo by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

    // Variables de error
    var errorCorreo by remember { mutableStateOf(false) }
    var errorContrasenia by remember { mutableStateOf(false) }
    var errorNombre by remember { mutableStateOf(false) }
    var errorApellido by remember { mutableStateOf(false) }
    var errorCedula by remember { mutableStateOf(false) }
    var errorCelular by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Registro Usuario", color = Color.White) },
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
                .verticalScroll(rememberScrollState()), // Habilita el desplazamiento vertical
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo de la aplicación
            Image(
                painter = painterResource(R.drawable.logooficial),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(230.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )

            // Formulario de registro
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), // Padding para mejor visibilidad en pantallas pequeñas
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
                    errorMessage = "Ingrese el correo por favor"
                )

                EspacioV(8)

                IngresarTexto(
                    label = "Contraseña",
                    placeholder = "Ingrese su contraseña",
                    value = contrasenia,
                    onValueChange = {
                        contrasenia = it
                        errorContrasenia = it.isEmpty()
                    },
                    isError = errorContrasenia,
                    errorMessage = "Ingrese la contraseña por favor"
                )

                EspacioV(8)

                IngresarTexto(
                    label = "Nombre",
                    placeholder = "Ingrese su nombre",
                    value = nombre,
                    onValueChange = {
                        nombre = it
                        errorNombre = it.isEmpty()
                    },
                    isError = errorNombre,
                    errorMessage = "Ingrese su nombre por favor"
                )

                EspacioV(8)

                IngresarTexto(
                    label = "Apellido",
                    placeholder = "Ingrese su apellido",
                    value = apellido,
                    onValueChange = {
                        apellido = it
                        errorApellido = it.isEmpty()
                    },
                    isError = errorApellido,
                    errorMessage = "Ingrese su apellido por favor"
                )

                EspacioV(8)

                IngresarTexto(
                    label = "Cédula",
                    placeholder = "Ingrese su cédula",
                    value = cedula,
                    onValueChange = {
                        cedula = it
                        errorCedula = it.isEmpty()
                    },
                    isError = errorCedula,
                    errorMessage = "Ingrese su cédula por favor"
                )

                EspacioV(8)

                IngresarTexto(
                    label = "Celular",
                    placeholder = "Ingrese su celular",
                    value = celular,
                    onValueChange = {
                        celular = it
                        errorCelular = it.isEmpty()
                    },
                    isError = errorCelular,
                    errorMessage = "Ingrese su celular por favor"
                )

                EspacioV(20)

                // Botón de registro
                BotonBasico(texto = "Registrarse", tamanio = 20) {
                    // Aquí iría la lógica para registrar al usuario
                }

                EspacioV(20) // Espacio al final para evitar que el botón quede pegado abajo
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistPreviaRegistroUsuario() {
    val navController = rememberNavController()
    RegistroUsuario(navController)
}
