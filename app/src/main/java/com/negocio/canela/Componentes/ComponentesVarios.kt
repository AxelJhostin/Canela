package com.negocio.canela.Componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val VerdeCanela = Color(8, 76, 3)
val BlancoTexto = Color.White
val RojoError = Color(255, 0, 0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngresarTexto(
    label: String,
    placeholder: String = "",
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = "",
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label, color = BlancoTexto) },  // Texto en blanco para mejor visibilidad
            placeholder = { Text(placeholder, color = BlancoTexto.copy(alpha = 0.7f)) },
            isError = isError,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = BlancoTexto,  // Borde cuando está enfocado
                unfocusedBorderColor = BlancoTexto.copy(alpha = 0.5f),  // Borde cuando no está enfocado
                cursorColor = BlancoTexto,  // Color del cursor
                errorBorderColor = RojoError,  // Borde en caso de error
                focusedTextColor = BlancoTexto,  // Color del texto ingresado
                unfocusedTextColor = BlancoTexto
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                if (isError) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Error",
                        tint = RojoError
                    )
                }
            }
        )

        // Muestra el mensaje de error si hay un error
        if (isError) {
            Text(
                text = errorMessage,
                color = RojoError,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}