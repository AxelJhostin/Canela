package com.negocio.canela.Vistas

import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.negocio.canela.Componentes.BotonBasico
import com.negocio.canela.Componentes.EspacioV
import com.negocio.canela.Componentes.IngresarTexto
import com.negocio.canela.R
import com.negocio.canela.ViewModel.LoginAdministradorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroAdministrador(navController: NavController, loginAdministradorViewModel: LoginAdministradorViewModel) {

    // Variables de entrada
    var correo by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }
    var codigoAcceso by remember { mutableStateOf("") }

    // Código de acceso válido
    val codigoCorrecto = "admin123"

    // Variables de error
    var errorCorreo by remember { mutableStateOf(false) }
    var errorNombre by remember { mutableStateOf(false) }
    var errorApellido by remember { mutableStateOf(false) }
    var errorContrasenia by remember { mutableStateOf(false) }
    var errorCedula by remember { mutableStateOf(false) }
    var errorCelular by remember { mutableStateOf(false) }
    var errorCodigo by remember { mutableStateOf(false) }
    var mensajeError by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Registro Administrador", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(8, 76, 3) // Color de la barra superior
                )
            )
        },
        containerColor = Color(8,76,3)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), // Padding para mejor visibilidad en pantallas pequeñas
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                EspacioV(10)
                IngresarTexto("Correo", "Ingrese su correo", correo, { correo = it })
                IngresarTexto("Nombre", "Ingrese su nombre", nombre, { nombre = it })
                IngresarTexto("Apellido", "Ingrese su apellido", apellido, { apellido = it })
                IngresarTexto("Contraseña", "Ingrese su contraseña", contrasenia, { contrasenia = it })
                IngresarTexto("Cédula", "Ingrese su cédula", cedula, { cedula = it })
                IngresarTexto("Celular", "Ingrese su celular", celular, { celular = it })
                IngresarTexto("Código de Acceso", "Ingrese código de acceso", codigoAcceso, { codigoAcceso = it })

                EspacioV(20)
                BotonBasico("Registrar Administrador", 20) {
                    // Validación de datos
                    errorCorreo = correo.isBlank() || !correo.contains("@")
                    errorNombre = nombre.isBlank()
                    errorApellido = apellido.isBlank()
                    errorCedula = cedula.isBlank()
                    errorCelular = celular.isBlank()
                    errorContrasenia = contrasenia.isBlank()
                    errorCodigo = codigoAcceso != codigoCorrecto

                    if (!errorCorreo && !errorNombre && !errorApellido && !errorCedula && !errorCelular && !errorContrasenia && !errorCodigo) {
                        loginAdministradorViewModel.crearAdministrador(
                            correo, contrasenia, nombre, apellido, cedula, celular
                        ) { success, message ->
                            if (success) {
                                navController.navigate("InicioAdministrador")
                            } else {
                                loginAdministradorViewModel.mostrarError(message)
                            }
                        }
                    } else {
                        mensajeError = "Verifique los datos ingresados"
                        loginAdministradorViewModel.mostrarError(mensajeError)
                    }
                }
            }
        }
    }
}
