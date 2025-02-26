package com.negocio.canela.Componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonBasico(texto: String,tamanio: Int) {
    Button(
        onClick = {},
        modifier = Modifier.width(200.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(6, 55, 23),
            contentColor = Color.White
        ),
        shape = CutCornerShape(0),
        border = BorderStroke(2.dp, color = Color.White)
    ) {
        Text(texto, fontSize = tamanio.sp)
    }
}